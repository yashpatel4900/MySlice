package com.university.MySlice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Course {

    private long CourseID;
    private String courseName;
    private String Instructor;
    private List<Schedule> schedule;
    private int capacity;
    private String description;
    private int credit;

    public Course() {
    }

    public Course(long courseID, String courseName, int credit) {
        CourseID = courseID;
        this.courseName = courseName;
        this.credit = credit;
    }
}
