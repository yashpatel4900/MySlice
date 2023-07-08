package com.university.MySlice.models;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.university.MySlice.enums.WeekDay;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Schedule {
    private WeekDay weekDay;
    private List<Slot> slots;

//    Constructor
    public Schedule(WeekDay weekDay, List<Slot> slots) {
        this.weekDay = weekDay;
        this.slots = slots;
    }
}
