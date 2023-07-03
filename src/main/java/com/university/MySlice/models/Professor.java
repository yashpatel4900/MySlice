package com.university.MySlice.models;

import com.university.MySlice.enums.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection="Professor")
public class Professor extends User{

//    @Id
    private long professorID;
    private String program;
    private String Office;
    private String Teaching;

    public Professor() {
        super();
    }

    public Professor(long userID, String name, String email, Role role, long professorID) {
        super(userID, name, email, role);
        this.professorID = professorID;
    }
}
