package com.university.MySlice.models;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.university.MySlice.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.university.MySlice.enums.Semester;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Document(collection="Enrollment")
public class Enrollment {

    @Id
    private Long enrollmentID;
    private Long suid;
    private Course course;
    private Date enrollmentDate;
    private Semester enrollmentSemester;
    private Integer year;
    private Status status;

    public Enrollment(Long enrollmentID, Long suid, Course course, Date enrollmentDate, Semester enrollmentSemester, int year, Status status) {
        this.enrollmentID = enrollmentID;
        this.suid = suid;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.enrollmentSemester = enrollmentSemester;
        this.year = year;
        this.status = status;
    }

    public Enrollment() {
    }
}
