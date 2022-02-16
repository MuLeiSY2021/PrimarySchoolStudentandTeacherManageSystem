package com.company.BaseClass;

import com.company.BaseClass.Hunman.Teacher;
import com.company.BaseClass.LsnTime.DayTime;
import com.company.BaseClass.StuAbout.StuClass;
import com.company.DataBaseAbout.AlDataBase;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Objects;

public class Lesson {
    private final int id;
    private static int count;
    private String name;
    private int room;
    private int dayTime;
    private int weekday;
    private Teacher teacher;
    private Subject subject;
    private Schedule schedule;

    //--------------------------------------//
    private int IdCounter(){
        Month temMonth = Month.of(LocalDate.now().getMonthValue());
        if( !(temMonth.equals(AlDataBase.getMonth())) ) {
            count = 0;
            AlDataBase.setMonth(temMonth);
        }
        return Year.now().getValue()*10000000 + AlDataBase.getMonth().getValue()*100000 + count;
    }

    public Lesson(int id) {
        this.id = id;
    }

    public Lesson(String name, int room, int dayTime, int weekday, Teacher teacher, Subject subject, Schedule schedule) {
        this.id = IdCounter();
        count++;
        this.name = name;
        this.room = room;
        this.dayTime = dayTime;
        this.weekday = weekday;
        this.teacher = teacher;
        this.subject = subject;
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id == lesson.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Lesson.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public StuClass getStuClass() {
        return stuClass;
    }

    public void setStuClass(StuClass stuClass) {
        this.stuClass = stuClass;
    }

    public Subject getSujbect() {
        return subject;
    }

    public void setSujbect(Subject subject) {
        this.subject = subject;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setDayTime(int dayTime) {
        this.dayTime = dayTime;
    }

    public int getDayTime() {
        return dayTime;
    }

}
