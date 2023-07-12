package com.university.MySlice.service;

import com.university.MySlice.enums.Status;
import com.university.MySlice.exception.RequiredFieldException;
import com.university.MySlice.models.Course;
import com.university.MySlice.models.Enrollment;
import com.university.MySlice.models.Schedule;
import com.university.MySlice.repository.EnrollmentRepository;
import com.university.MySlice.repository.UserRepository;
import com.university.MySlice.utils.RandomIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.university.MySlice.models.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EnrollmentService enrollmentService;
    @Autowired
    CourseService courseService;

//        On Autowiring of userRepository, either we can use methods provided by MongoDB or
//        we can create new methods in userRepository and use it.
        public User getUserById(long Id){
            return userRepository.findByID(Id);
        }

        public List<User> findUsersByName(String name){
            return userRepository.findByName(name);
        }

        public void saveUser(User user) throws Exception{
//      While saving user we gave a functionality to user that either they can pass ID or we can generate a random id for them


                if(user.getName() == null){
                    // Raise Exception
                    throw new RequiredFieldException("Name is a required field");
                }

//                If user didnt gave id, we will generate
                if(user.getUserID() == null){
//                    Save new user
                    user.setUserID(RandomIDGenerator.generateRandomId());
                } else{
//                    If id given, check same id does not exist
                    User existingUser = userRepository.findByID(user.getUserID());
//                    If exist and there is also non-other user with same name, we can save it now
                    if(existingUser != null && !user.getName().equals(existingUser.getName())){
                        // Name change, raise exception
                        throw new Exception("Changing name is not allowed");
                    }
                }

                userRepository.save(user);
        }

    public Page<User> getAllUsers(Pageable pageRequest) {
            return userRepository.findAll(pageRequest);
    }

    public List<Schedule> getSchedule(Long userId) throws Exception {
        List<Enrollment> enrollmentList = enrollmentService.getEnrollmentsByStudentId(userId);
        User user = getUserById(userId);
        List<Schedule> fetchedSchedules = new ArrayList<>();

        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getStatus() == Status.ACTIVE) {
                Long courseId = enrollment.getCourse().getCourseID();
                Course course = courseService.getCourseByID(courseId);

                if (course != null) {
                    List<Schedule> courseSchedules = course.getSchedule();
                    fetchedSchedules.addAll(courseSchedules);
                }
            }
        }

        user.setSchedule(fetchedSchedules);
        saveUser(user);
        return user.getSchedule();
    }

//    public List<Schedule> getSchedule(Long userId) {
//        List<Enrollment> enrollmentList = enrollmentService.getEnrollmentsByStudentId(userId);
//        User user = userRepository.findByID(userId);
//        List<Schedule> fetchedSchedules = new ArrayList<>();
//        for(Enrollment enrollment: enrollmentList){
//            if(enrollment.getStatus() == Status.ACTIVE){
//                Long courseId = enrollment.getCourse().getCourseID();
//                List<Schedule> fetchedSchedule = courseService.getCourseByID(courseId).getSchedule();
//
//                fetchedSchedules.addAll(fetchedSchedule);
//
//            }
//        }
//
//        user.setSchedule(fetchedSchedules);
//        return user.getSchedule();
//    }
}
