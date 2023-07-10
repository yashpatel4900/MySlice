package com.university.MySlice.service;

import com.university.MySlice.exception.RequiredFieldException;
import com.university.MySlice.models.Course;
import com.university.MySlice.models.Program;
import com.university.MySlice.models.User;
import com.university.MySlice.repository.CourseRepository;
import com.university.MySlice.utils.RandomIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;



    public Course saveCourse(Course course) throws Exception {
        if (course.getCourseName() == null) {
            // Raise Exception
            throw new RequiredFieldException("Name is a required field");
        }

//                If user didnt gave id, we will generate
        if (course.getCourseID() == null) {
//                    Save new user
            course.setCourseID(RandomIDGenerator.generateRandomId());
        } else {
//                    If id given, check same id does not exist
            Course existingCourse = courseRepository.findById(course.getCourseID());
//                    If exist and there is also non-other user with same name, we can save it now
            if (existingCourse != null && !course.getCourseName().equals(existingCourse.getCourseName())) {
                // Name change, raise exception
                throw new Exception("Changing name is not allowed");
            }
        }

        return courseRepository.save(course);
    }

    public Course getCourseByID(Long courseID) {
        return courseRepository.findById(courseID);
    }
}
