package com.university.MySlice.models;

import java.sql.Time;

public class Slot {

    private Time startTime;
    private Time endTime;

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //    Empty Constructor for no slot of the day
    public Slot() {
    }

//    Main constructor to define timings
    public Slot(Time startTime, Time endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
