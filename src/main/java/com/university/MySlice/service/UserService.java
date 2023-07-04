package com.university.MySlice.service;

import com.university.MySlice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.university.MySlice.models.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

//        On Autowiring of userRepository, either we can use methods provided by MongoDB or
//        we can create new methods in userRepository and use it.
        public User getUserById(long Id){
            return userRepository.findByID(Id);
        }

        public List<User> findUsersByName(String name){
            return userRepository.findByName(name);
        }

        public User saveUser(User user) throws Exception{

            User existingUser = userRepository.getByName(user.getName());

            if(existingUser == null){
                userRepository.save(user);
            }

            throw new Exception(String.format("User already exists with name %s", user.getName()));

        }
}
