package com.company.BaseClass.LsnTime;

import java.sql.Time;

public class DayTime {
    private static int number;
    private int id;
    private int startTime;
    private int overTime;

    public String toString(){
        return String.valueOf(startTime/100 + ':' + startTime%100 + '-' + overTime/100 + ':' + overTime%100 + '-');
    }

    public DayTime(int id, int startTime, int overTime) {
        this.id = id;
        this.startTime = startTime;
        this.overTime = overTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }
}
