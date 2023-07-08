package com.university.MySlice.controller;

import com.university.MySlice.exception.RequiredFieldException;
import com.university.MySlice.models.*;
import com.university.MySlice.repository.UserRepository;
import com.university.MySlice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) throws Exception {
//        logger.info("Saving Mode.");
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }

        return "User has been created Successfully";
    }

    //    GET API Request to fetch user by ID
    @GetMapping(value = "/getByID")
    public User getUserByID(@RequestParam long id) {
//      findByID was defined by us in userRepository Interface using @Query
        return userService.getUserById(id);
    }

    @GetMapping(value = "/findUsersByName")
    List<User> findUsersByName(@RequestParam String name) {
        return userService.findUsersByName(name);
    }
}
