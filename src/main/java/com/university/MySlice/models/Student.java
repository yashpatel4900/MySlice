package com.university.MySlice.models;

import com.university.MySlice.enums.Semester;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student extends User {

    private long suid;
    private String program;

    private Semester semester;
    private int year;

    private float creditCost;
    private int scholarship;
    private List<Transcript> transcript;

    public Student() {
        super();
    }

    public Student(long userID, String name, String email, String role, long suid) {
        super(userID, name, email, role);
        this.suid = suid;
    }
}
