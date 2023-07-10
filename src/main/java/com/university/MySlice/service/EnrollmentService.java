package com.university.MySlice.service;

import com.university.MySlice.enums.Status;
import com.university.MySlice.exception.RequiredFieldException;
import com.university.MySlice.models.Course;
import com.university.MySlice.models.Enrollment;
import com.university.MySlice.models.Program;
import com.university.MySlice.models.User;
import com.university.MySlice.repository.EnrollmentRepository;
import com.university.MySlice.repository.CourseRepository;
import com.university.MySlice.utils.RandomIDGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    EnrollmentRepository enrollmentRepository;
    @Autowired
    CourseRepository courseRepository;

    public void createEnrollment(Enrollment enrollment) {
        // Check if course is selected for enrollment
        if (enrollment.getCourse() == null) {
            throw new RequiredFieldException("Course must be selected to enroll");
        }

        // Retrieve existing enrollments for the same SUID and CourseID combination
        List<Enrollment> existingEnrollments = enrollmentRepository.findBySUIDCourseID(enrollment.getSuid(), enrollment.getCourse().getCourseID());

        for (Enrollment existingEnrollment : existingEnrollments) {
            if (existingEnrollment.getStatus().equals(Status.ACTIVE) || existingEnrollment.getStatus().equals(Status.COMPLETED)) {
                throw new RequiredFieldException("Student has already completed the course or is already enrolled");
            }
        }

        // Generate enrollmentID if not provided
        if (enrollment.getEnrollmentID() == null) {
            enrollment.setEnrollmentID(RandomIDGenerator.generateRandomId());
        }

        // Check if SUID is provided
        if (enrollment.getSuid() == null) {
            throw new RequiredFieldException("SUID must be provided");
        }

//        Complete this function after AUTHENTICATION
        // Check if suid exists in the database
//        if (enrollment.getSuid() == studentRepository.findBySuid(enrollment.getSuid())) {
//            throw new RequiredFieldException("Invalid SUID");
//        }
//

        // Check if courseID matches any courseID in the database
        Course course = courseRepository.findById(enrollment.getCourse().getCourseID());
        if (course == null) {
            throw new RequiredFieldException("Course not found");
        }

        // Check if enrollmentSemester and year are provided
        if (enrollment.getEnrollmentSemester() == null || enrollment.getYear() == null) {
            throw new RequiredFieldException("Enrollment semester and year must be provided");
        }

        // Set status to Active
        enrollment.setStatus(Status.ACTIVE);

        // Assign current date to enrollmentDate
        enrollment.setEnrollmentDate(new Date());

        enrollmentRepository.save(enrollment);
    }


    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        // Check if studentId is provided
        if (studentId == null) {
            throw new RequiredFieldException("Student ID must be provided");
        }

        // Retrieve enrollments by studentId
        List<Enrollment> enrollments = enrollmentRepository.findBySUID(studentId);

        if (enrollments.isEmpty()) {
            throw new RequiredFieldException("No enrollments found for the student ID: " + studentId);
        }

        return enrollments;
    }


    public void setEnrollmentStatusComplete(Long enrollmentId) {
        // Retrieve the enrollment by ID
        Enrollment enrollment = getEnrollmentById(enrollmentId);

        // Check if the enrollment status is currently active
        if (enrollment.getStatus() == Status.ACTIVE) {
            // Update the status to completed
            enrollment.setStatus(Status.COMPLETED);
            // Save the updated enrollment
            enrollmentRepository.save(enrollment);
        } else {
            throw new RequiredFieldException("Enrollment status is not active");
        }
    }

    public Enrollment getEnrollmentById(Long enrollmentId) {
        // Check if enrollmentId is provided
        if (enrollmentId == null) {
            throw new RequiredFieldException("Enrollment ID must be provided");
        }

        // Retrieve the enrollment by ID
        Enrollment enrollmentOptional = enrollmentRepository.findByEnrollmentId(enrollmentId);
        if (enrollmentOptional == null) {
            throw new RequiredFieldException("Enrollment not found with ID: " + enrollmentId);
        }

        return enrollmentOptional;
    }

}
