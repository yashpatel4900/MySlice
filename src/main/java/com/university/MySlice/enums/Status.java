package com.university.MySlice.enums;

public enum Status {
    COMPLETED("Completed"),
    DROPPED("Dropped"),
    ACTIVE("Active");


    private final String status;
    Status(String status) {
        this.status = status;
    }
    public String getStatus(String status){
        return this.status;
    }

}
