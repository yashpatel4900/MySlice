package com.university.MySlice.models;
import com.university.MySlice.enums.WeekDay;

import java.util.List;

public class Schedule {
    private WeekDay weekDay;
    private List<Slot> slots;

//    Constructor
    public Schedule(WeekDay weekDay, List<Slot> slots) {
        this.weekDay = weekDay;
        this.slots = slots;
    }

//    Getter Setter
    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
