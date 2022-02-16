package com.company.BaseClass;

import com.company.BaseClass.StuAbout.StuClass;
import com.company.DataBaseAbout.AlDataBase;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;

public class Schedule {
    private static int count;
    private final int id;
    private Lesson[][] lessonMap;
    private StuClass stuClass;

    private int IdCounter(){
        Month temMonth = Month.of(LocalDate.now().getMonthValue());
        if( !(temMonth.equals(AlDataBase.getMonth())) ) {
            count = 0;
            AlDataBase.setMonth(temMonth);
        }
        return Year.now().getValue()*10000000 + AlDataBase.getMonth().getValue()*100000 + count;
    }

    public Schedule() {
        lessonMap = new Lesson[5][6];
        id = IdCounter();
        count++;
    }

    public Schedule(int id) {
        this.id = id;
    }

    public Schedule(Lesson[][] lessonMap) {
        this.lessonMap = lessonMap;
        id = IdCounter();
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Arrays.deepEquals(getLessonMap(), schedule.getLessonMap());
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(getLessonMap());
    }

    public Lesson[][] getLessonMap() {
        return lessonMap;
    }

    public void setStuClass(StuClass stuClass) {
        this.stuClass = stuClass;
    }

    public void setLessonMap(Lesson[][] lessonMap) {
        this.lessonMap = lessonMap;
    }
}
