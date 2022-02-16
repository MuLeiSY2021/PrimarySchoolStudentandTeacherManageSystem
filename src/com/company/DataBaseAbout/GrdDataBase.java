package com.company.DataBaseAbout;

import com.company.BaseClass.StuAbout.StuGrade;

public class GrdDataBase {
    private final StuGrade[] stuGrades;

    public GrdDataBase() {
        stuGrades = new StuGrade[6];
        for (int i = 0; i < 6; i++) {
            stuGrades[i] = new StuGrade(i + 1);
        }
    }

    public StuGrade[] getStuGrades() {
        return stuGrades;
    }

    public StuGrade getGrade(int index) {
        return stuGrades[index - 1];
    }


}
