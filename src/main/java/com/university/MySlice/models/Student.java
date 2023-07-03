package com.university.MySlice.models;

import com.university.MySlice.enums.Role;
import com.university.MySlice.enums.Semester;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter

@Document(collection="student")
public class Student extends User {

//    @Id
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

    public Student(long userID, String name, String email, Role role, long suid) {
        super(userID, name, email, role);
        this.suid = suid;
    }
}
