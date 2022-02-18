package com.company.BaseClass.Hunman;

import com.company.BaseClass.StuAbout.StuClass;
import com.company.BaseClass.StuAbout.StuGrade;
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

    //------删除成员------//
    public void delete() {
        teaGrade = null;
        teaClass.setClassTeacher(null);
        teaClass = null;
    }
    //-------------------//

    //------查找成员------//
    public StuGrade getTeaGrade() {
        return teaGrade;
    }

    public StuClass getTeaClass() {
        return teaClass;
    }
    //-------------------//

    //------修改成员------//
    public void modify(ClassTeacher classTeacher){
        if(classTeacher.getTeaClass() != null || !classTeacher.getTeaClass().equals(this.teaClass)){
            this.teaClass = classTeacher.teaClass;
        }
        if(classTeacher.getTeaGrade() != null || !classTeacher.getTeaGrade().equals(this.teaGrade)){
            this.teaGrade = classTeacher.teaGrade;
        }
    }

    public void setTeaGrade(StuGrade teaGrade) {
        this.teaGrade = teaGrade;
    }

    public void setTeaClass(StuClass teaClass) {
        this.teaClass = teaClass;
    }
    //-------------------//

    //------插入成员------//
    public ClassTeacher() {
    }

    public ClassTeacher(String name, boolean gender, int age, LsnDataBase lessons, int office, StuGrade teaGrade, StuClass teaClass) {
        super(name, gender, age, lessons, office);
        this.teaGrade = teaGrade;
        this.teaClass = teaClass;
    }
    //-------------------//
    public Teacher() {
    }

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

    public static void countAdd() {
        ++ count;
    }
}
