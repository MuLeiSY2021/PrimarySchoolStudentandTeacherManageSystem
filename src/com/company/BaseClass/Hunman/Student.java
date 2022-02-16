package com.company.BaseClass.Hunman;

import com.company.BaseClass.Schedule;
import com.company.BaseClass.Score;
import com.company.BaseClass.StuAbout.StuClass;
import com.company.BaseClass.StuAbout.StuGrade;
import com.company.DataBaseAbout.AlDataBase;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Objects;

public class Student extends Person {
    private final int id;
    private StuClass stuClass;
    private ClassTeacher classTeacher;
    private static int count;
    private Schedule schedule;
    private Score score;

    //----------------------------------//
    private int IdCounter(){
        Month temMonth = Month.of(LocalDate.now().getMonthValue());
        if( !(temMonth.equals(AlDataBase.getMonth())) ) {
            count = 0;
            AlDataBase.setMonth(temMonth);
        }
        return Year.now().getValue()*10000000 + AlDataBase.getMonth().getValue()*100000 + count;
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(String name, boolean gender, int age) {
        super(name, gender, age);
        this.id = IdCounter();
        count++;
    }

    public Student(String name, boolean gender, int age, StuClass stuClass, ClassTeacher classTeacher, Schedule schedule, Score score) {
        super(name, gender, age);
        this.stuClass = stuClass;
        this.classTeacher = classTeacher;
        this.schedule = schedule;
        this.score = score;
        this.id = IdCounter();
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public StuClass getStuClass() {
        return stuClass;
    }

    public void setStuClass(StuClass stuClass) {
        this.stuClass = stuClass;
    }

    public ClassTeacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(ClassTeacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Score getScoreList() {
        return score;
    }

    public void setScoreList(Score score) {
        this.score = score;
    }
}
