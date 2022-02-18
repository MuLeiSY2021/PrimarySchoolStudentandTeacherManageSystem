package com.company.BaseClass.Hunman;

import com.company.BaseClass.StuAbout.StuClass;
import com.company.BaseClass.StuAbout.StuGrade;
import com.company.DataBaseAbout.LsnDataBase;

public class ClassTeacher extends Teacher {
    private static int count;
    private StuGrade teaGrade;
    private StuClass teaClass;
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
    //-------------------//

    //------插入成员------//
    public ClassTeacher() {
    }

    public ClassTeacher(String name, boolean gender, int age, LsnDataBase lessons, int office, StuGrade teaGrade, StuClass teaClass) {
        id =
        super(name, gender, age, lessons, office);
        this.teaGrade = teaGrade;
        this.teaClass = teaClass;
        Teacher.countAdd();
        ClassTeacher.countAdd();
    }
    //-------------------//
}
