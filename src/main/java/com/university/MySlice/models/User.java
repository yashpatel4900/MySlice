package com.university.MySlice.models;
import com.university.MySlice.enums.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Document(collection = "users")
public class User {
    @Id
    private long userID;
    private String name;
    private String email;
    private Role role;

    private List<Schedule> schedule;

//    We are not defining Notification here because no need of it in DB.


    public User() {
    }

    public User(long userID, String name, String email, Role role) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.role = role;
    }


}
