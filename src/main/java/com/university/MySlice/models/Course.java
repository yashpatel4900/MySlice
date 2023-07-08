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
    private Long courseID;
    private String courseName;
    private String instructor;
    private List<Schedule> schedule;
    private Integer capacity;
    private String description;
    private Integer credit;

    public Course() {
    }

    public Course(Long courseID, String courseName, Integer credit) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credit = credit;
    }
}
