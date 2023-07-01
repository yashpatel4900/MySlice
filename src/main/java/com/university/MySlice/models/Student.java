package com.university.MySlice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student extends User {

    private int suid;
    private String program;

    private String semester;

    private float creditCost;
    private int scholarship;
    private List<Transcript> transcript;

    public Student() {
        super();
    }

    public Student(String userID, String name, String email, String role, int suid) {
        super(userID, name, email, role);
        this.suid = suid;
    }
}
