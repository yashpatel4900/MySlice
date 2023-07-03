package com.university.MySlice.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.university.MySlice.enums.Semester;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document(collection="Enrollment")
public class Enrollment {

    @Id
    private long enrollmentID;
    private long suid;
    private List<Course> courses;
    private Date enrollmentDate;
    private Semester enrollmentSemester;
    private int year;
    private String status;

    public Enrollment(long enrollmentID, long suid, List<Course> courses, Date enrollmentDate, Semester enrollmentSemester, int year, String status) {
        this.enrollmentID = enrollmentID;
        this.suid = suid;
        this.courses = courses;
        this.enrollmentDate = enrollmentDate;
        this.enrollmentSemester = enrollmentSemester;
        this.year = year;
        this.status = status;
    }

    public Enrollment() {
    }
}
