package com.company.BaseClass.StuAbout;

import com.company.DataBaseAbout.HumanDataBases.StuDataBase;
import com.company.BaseClass.Hunman.ClassTeacher;
import com.company.BaseClass.Schedule;

import java.util.Objects;

public class StuClass {
    static private int number;
    private final int id;
    private StuGrade stuGrade;
    private StuDataBase students;
    private ClassTeacher classTeacher;
    private Schedule schedule;
    //------------------------------------//
    public StuClass(int id) {
        this.id = id;
    }

    public StuClass(int id, StuGrade stuGrade, StuDataBase students, ClassTeacher classTeacher, Schedule schedule) {
        number++;
        this.id = number;
        this.stuGrade = stuGrade;
        this.students = students;
        this.classTeacher = classTeacher;
        this.schedule = schedule;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StuClass stuClass = (StuClass) o;
        return id == stuClass.id && stuGrade.getId() == stuClass.stuGrade.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stuGrade.getId());
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        StuClass.number = number;
    }

    public int getId() {
        return id;
    }

    public StuGrade getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(StuGrade stuGrade) {
        this.stuGrade = stuGrade;
    }

    public StuDataBase getStudents() {
        return students;
    }

    public void setStudents(StuDataBase students) {
        this.students = students;
    }

    public ClassTeacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(ClassTeacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
