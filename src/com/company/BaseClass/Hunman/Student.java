package com.company.BaseClass.Hunman;

import com.company.BaseClass.Schedule;
import com.company.BaseClass.Score;
import com.company.BaseClass.StuAbout.StuClass;
import com.company.BaseClass.StuAbout.StuGrade;
import com.company.DataBaseAbout.AlDataBase;
import com.company.DataBaseAbout.LsnDataBase;

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

    //------删除成员------//
    public void delete() {
        stuClass.getStudents().delectStu();
        stuClass = null;
        classTeacher = null;

    }
    //-------------------//

    //------查找成员------//
    public StuGrade getTeaGrade() {
        return teaGrade;
    }

    public StuClass getTeaClass() {
        return teaClass;
    }

    public static int getCount() {
        return count;
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

    public static void countAdd() {
        ++ count;
    }

    private int IdCounter(){
        Month temMonth = Month.of(LocalDate.now().getMonthValue());
        if( !(temMonth.equals(AlDataBase.getMonth())) ) {
            count = 0;
            AlDataBase.setMonth(temMonth);
        }
        return Year.now().getValue()*10000000 + AlDataBase.getMonth().getValue()*100000 + count;
    }
    //-------------------//

    //------插入成员------//
    public Student() {
    }

    public Student(String name, boolean gender, int age, StuClass stuClass, ClassTeacher classTeacher, Schedule schedule, Score score) {
        super(name, gender, age);
        this.stuClass = stuClass;
        this.classTeacher = classTeacher;
        this.schedule = schedule;
        this.score = score;
        this.id = IdCounter();
        Student.countAdd();
    }
    //-------------------//

    //------其他方法------//
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
    //-------------------//
}
