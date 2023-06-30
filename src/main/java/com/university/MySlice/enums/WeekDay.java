package com.university.MySlice.enums;

public enum WeekDay {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String day;
    WeekDay(String day) {
        this.day = day;
    }
    public String getDay(String day){
        return this.day;
    }
}
