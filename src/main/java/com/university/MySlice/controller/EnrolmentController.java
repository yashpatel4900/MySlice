package com.university.MySlice.controller;

import com.university.MySlice.exception.RequiredFieldException;
import com.university.MySlice.models.Enrollment;
import com.university.MySlice.service.EnrollmentService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/enrollment")
public class EnrolmentController {

    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping("/save")
    public String createEnrollment(@RequestBody Enrollment enrollment) {
        try {
            enrollmentService.createEnrollment(enrollment);
            return "Enrollment created successfully";
        } catch (Exception e) {
            throw new RequiredFieldException(e.getMessage());
        }
    }

//    Service layer definetions remaining
    @GetMapping("/students/enrollments")
    public List<Enrollment> getEnrollmentsByStudentId(@RequestParam Long studentId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        return enrollments;
    }
    @PutMapping("update/complete")
    public String setEnrollmentStatusComplete(@RequestParam Long enrollmentId) {
        try {
            enrollmentService.setEnrollmentStatusComplete(enrollmentId);
            return "Enrollment status updated to completed";
            } catch (Exception e) {
                throw new RequiredFieldException(e.getMessage());
            }
    }

}


