package com.university.MySlice.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Document
public class User {
    @Id
    private long userID;

    private String name;
    private String email;
    private String role;

    private List<Schedule> schedule;

//    We are not defining Notification here because no need of it in DB.


    public User() {
    }

    public User(long userID, String name, String email, String role) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.role = role;
    }


}
