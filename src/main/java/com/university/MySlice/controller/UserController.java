package com.university.MySlice.controller;

import com.university.MySlice.models.*;
import com.university.MySlice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @PostMapping(value = "/save")
    void test(@RequestBody User user){
//        logger.info("Saving Mode.");
        userRepository.save(user);
//        userRepository.save(new Student());
//        userRepository.save(new Professor());
//        userRepository.save(new Program());
//        userRepository.save(new Course());
//        userRepository.save(new Enrollment());
//        userRepository.save(new Transcript());
    }
}
