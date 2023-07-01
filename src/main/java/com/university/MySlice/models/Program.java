package com.university.MySlice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Program {

    private long programID;
    private String programName;
    private String department;
    private String advisor;
    private String Description;
    private List<Course> courses;
    private int creditRequired;
    private int duration;
    private String degreeOffered;

    public Program() {
    }

    public Program(long programID, String programName, String department, int creditRequired, int duration, String degreeOffered) {
        this.programID = programID;
        this.programName = programName;
        this.department = department;
        this.creditRequired = creditRequired;
        this.duration = duration;
        this.degreeOffered = degreeOffered;
    }
}
