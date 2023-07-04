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
    private UserService userService;

    Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "/save")
    public void saveUser(@RequestBody User user){
//        logger.info("Saving Mode.");
        try{
            userService.saveUser(user);
        } catch(Exception e){
            LOGGER.error(e.getMessage());
        }
    }
}
