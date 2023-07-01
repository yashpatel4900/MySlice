package com.university.MySlice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Professor extends User{

    private long professorID;
    private String program;
    private String Office;
    private String Teaching;

    public Professor() {
        super();
    }

    public Professor(long userID, String name, String email, String role, long professorID) {
        super(userID, name, email, role);
        this.professorID = professorID;
    }
}
