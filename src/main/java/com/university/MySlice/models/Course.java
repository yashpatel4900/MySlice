package com.university.MySlice.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection="Course")
public class Course {

    @Id
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
