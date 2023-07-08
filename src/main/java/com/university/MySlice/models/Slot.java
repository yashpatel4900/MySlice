package com.university.MySlice.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Slot {

    private Time startTime;
    private Time endTime;

    private String location;

    //    Empty Constructor for no slot of the day
    public Slot() {
    }

//    Main constructor to define timings
    public Slot(Time startTime, Time endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
