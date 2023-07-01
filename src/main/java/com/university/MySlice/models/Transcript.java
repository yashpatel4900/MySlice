package com.university.MySlice.models;
import com.university.MySlice.enums.Grade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transcript {

    private long courseID;
    private String courseName;
    private int CourseCredit;
    private Grade grade;
    private boolean isPass;

    public Transcript() {
    }

    public Transcript(long courseID, boolean isPass) {
        this.courseID = courseID;
        this.isPass = isPass;
    }
}
