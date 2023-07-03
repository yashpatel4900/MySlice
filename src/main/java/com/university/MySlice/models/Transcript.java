package com.university.MySlice.models;
import com.university.MySlice.enums.Grade;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection="Transcript")
public class Transcript {

    @Id
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
