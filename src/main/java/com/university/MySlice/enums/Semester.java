package com.university.MySlice.enums;

public enum Semester {

    FALL("Fall"),
    SUMMER("Summer"),
    SPRING("Spring");


    private final String semester;
    Semester(String semester) {
        this.semester = semester;
    }
    public String getSemester(String semester){
        return this.semester;
    }
}
