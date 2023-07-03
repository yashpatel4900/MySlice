package com.university.MySlice.enums;

public enum Role {
    STUDENT("Student"),
    PROFESSOR("Professor"),
    ADMIN("Admin");


    private final String role;
    Role(String role) {
        this.role = role;
    }
    public String getRole(String role){
        return this.role;
    }
}
