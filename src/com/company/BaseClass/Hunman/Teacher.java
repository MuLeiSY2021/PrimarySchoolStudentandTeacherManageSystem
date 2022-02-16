package com.company.BaseClass.Hunman;

import com.company.DataBaseAbout.AlDataBase;
import com.company.DataBaseAbout.LsnDataBase;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Objects;

public class Teacher extends Person {
    private static int count;
    protected final int id;
    private LsnDataBase lessons;
    private int office;
    private boolean ClsTch;
    //------------------------------------//
    private int IdCounter(){
        Month temMonth = Month.of(LocalDate.now().getMonthValue());
        if( !(temMonth.equals(AlDataBase.getMonth())) ) {
            count = 0;
            AlDataBase.setMonth(temMonth);
        }
        return Year.now().getValue()*10000000 + AlDataBase.getMonth().getValue()*100000 + count;
    }

    public Teacher(int id) {
        this.id = id;
    }

    public Teacher(String name, boolean gender, int age, LsnDataBase lessons, int office) {
        super(name, gender, age);
        this.id = IdCounter();
        count++;
        this.lessons = lessons;
        this.office = office;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Teacher.count = count;
    }

    public int getId() {
        return id;
    }

    public LsnDataBase getLessons() {
        return lessons;
    }

    public void setLessons(LsnDataBase lessons) {
        this.lessons = lessons;
    }

    public int getOffice() {
        return office;
    }

    public void setOffice(int office) {
        this.office = office;
    }
}
