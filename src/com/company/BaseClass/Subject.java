package com.company.BaseClass;

import com.company.DataBaseAbout.AlDataBase;
import com.company.DataBaseAbout.LsnDataBase;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Objects;

public class Subject {
    private static int count;
    LsnDataBase lsnDataBase;
    private final int id;

    private int IdCounter(){
        Month temMonth = Month.of(LocalDate.now().getMonthValue());
        if( !(temMonth.equals(AlDataBase.getMonth())) ) {
            count = 0;
            AlDataBase.setMonth(temMonth);
        }
        return Year.now().getValue()*10000000 + AlDataBase.getMonth().getValue()*100000 + count;
    }

    public Subject(int id) {
        this.id = id;
    }

    public Subject(LsnDataBase lsnDataBase, int id) {
        this.lsnDataBase = lsnDataBase;
        this.id = IdCounter();
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Subject.count = count;
    }

    public LsnDataBase getLsnDataBase() {
        return lsnDataBase;
    }

    public void setLsnDataBase(LsnDataBase lsnDataBase) {
        this.lsnDataBase = lsnDataBase;
    }

    public int getId() {
        return id;
    }
}
