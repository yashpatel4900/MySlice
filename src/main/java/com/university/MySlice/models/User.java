package com.university.MySlice.models;

import lombok.Getter;
import lombok.Setter;

//@Document("user")
@Getter
@Setter
public class User {
//    @Id
    private String userID;

    private String name;
    private String email;
    private String role;

    private Schedule schedule;

//    We are not defining Notification here because no need of it in DB.


    public User(String userID, String name, String email, String role) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.role = role;
    }


}
