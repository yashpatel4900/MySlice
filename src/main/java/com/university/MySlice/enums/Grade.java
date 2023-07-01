package com.university.MySlice.enums;

public enum Grade {

    APLUS(10),
    A(9),
    BPLUS(8),
    B(7),
    CPLUS(6),
    C(5),
    D(4);

    private final int grade;
    Grade(int grade) {
        this.grade = grade;
    }
    public int getGrade(int grade){
        return this.grade;
    }
}
