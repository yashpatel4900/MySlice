package com.university.MySlice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Document(collection="Program")
public class Program {

    @Id
    private Long programID;
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

    public Program(Long programID, String programName, String department, int creditRequired, int duration, String degreeOffered) {
        this.programID = programID;
        this.programName = programName;
        this.department = department;
        this.creditRequired = creditRequired;
        this.duration = duration;
        this.degreeOffered = degreeOffered;
    }
}
