package com.company.DataBaseAbout;

import com.company.DataBaseAbout.HumanDataBases.ClsTchDataBase;
import com.company.DataBaseAbout.HumanDataBases.StuDataBase;
import com.company.DataBaseAbout.HumanDataBases.TchDataBase;

import java.time.Month;

public class AlDataBase {
    private static Month month;
    GrdDataBase grdDataBase;
    ClsDataBase clsDataBase;
    StuDataBase stuDataBase;
    TchDataBase tchDataBase;
    ClsTchDataBase clsTchDataBase;
    SchDataBase schDataBase;
    LsnDataBase lsnDataBase;

    public static Month getMonth() {
        return month;
    }

    public static void setMonth(Month month) {
        AlDataBase.month = month;
    }

}
