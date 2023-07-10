package com.university.MySlice.service;

import com.university.MySlice.exception.RequiredFieldException;
import com.university.MySlice.models.Course;
import com.university.MySlice.models.Program;
import com.university.MySlice.repository.ProgramRepository;
import com.university.MySlice.utils.RandomIDGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProgramService {
    @Autowired
    ProgramRepository programRepository;
    @Autowired
    CourseService courseService;

    public void saveProgram(Program program) throws Exception{

//        Checks if name was not passed OR If we already have same program name in database.
        if(program==null || program.getProgramName()==null){
            throw new RequiredFieldException("Program name must be passed");
        }

        Program existingProgram = programRepository.findByName(program.getProgramName());

        if(existingProgram!=null){
            throw new RequiredFieldException("Same Program name Exists in DataBase");
        }

//        Handling ID
        if(program.getProgramID()==null){
            program.setProgramID(RandomIDGenerator.generateRandomId());
        } else {
            Program existingProgramByID = programRepository.findById(program.getProgramID());
            if(existingProgramByID!=null && !program.getProgramName().equals(existingProgramByID.getProgramName())){
                throw new RequiredFieldException("Changing name is not allowed");
            }
        }

//        Handling Courses while saving Program
        if(CollectionUtils.isNotEmpty(program.getCourses())){

            List<Course> editedCourses = new ArrayList<>();
            for(Course course : program.getCourses()){
                // Saving each course
                course = courseService.saveCourse(course);

                // Just fetching courseID and making rest fields null.
                editedCourses.add(new Course(course.getCourseID()));
            }
            program.setCourses(editedCourses);
        }


        programRepository.save(program);
    }


    public Program getProgramById (Long id){
        try {
        Program fetchedProgram = programRepository.findById(id);
        if (fetchedProgram == null) {
            throw new RequiredFieldException("No Program found bu this ID");
        }
        List<Course> courses = new ArrayList<>();
        for (Course course : fetchedProgram.getCourses()) {
            // Fetching a particular Course Detail
            Course courseInDb = courseService.getCourseByID(course.getCourseID());
            if (courseInDb == null) {
                throw new RequiredFieldException("App ne haga hai code mein. Program mein courses jo save thhe wo courses ke database nahi hai. Enjoy");
            }
            courses.add(courseInDb);
        }
        fetchedProgram.setCourses(courses);
        return fetchedProgram;
        } catch(Exception e) {
            throw new RequiredFieldException(e.getMessage());
        }
    }

}
