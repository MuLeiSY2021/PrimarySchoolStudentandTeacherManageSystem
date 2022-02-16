package com.company.BaseClass.Hunman;

import com.company.BaseClass.StuAbout.StuClass;
import com.company.BaseClass.StuAbout.StuGrade;
import com.company.DataBaseAbout.LsnDataBase;

public class ClassTeacher extends Teacher {
    private StuGrade teaGrade;
    private StuClass teaClass;
    //------------------------------------//

    public ClassTeacher(int id) {
        super(id);
    }

    public ClassTeacher(String name, boolean gender, int age, LsnDataBase lessons, int office, StuClass teaClass) {
        super(name, gender, age, lessons, office);
        this.teaClass = teaClass;
    }

    public void setTeaGrade(StuGrade teaGrade) {
        this.teaGrade = teaGrade;
    }

    public void setTeaClass(StuClass teaClass) {
        this.teaClass = teaClass;
    }
}
