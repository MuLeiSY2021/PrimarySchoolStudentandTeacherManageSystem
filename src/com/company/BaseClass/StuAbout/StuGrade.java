package com.company.BaseClass.StuAbout;

import com.company.DataBaseAbout.ClsDataBase;

import java.util.Objects;

public class StuGrade {
    private final int id;
    private ClsDataBase clsDataBase;

    //--------------------------------------------//
    public StuGrade(int id) {
        this.id = id;
    }

    public void refreshCls() {
        clsDataBase.deleteAll();
        clsDataBase.addAll(ClsDataBase.getAllClsDataBase().select(new StuClass(0,this,null,null,null),0,false,0,false));
    }

    public int size(){
        return clsDataBase.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StuGrade stuGrade = (StuGrade) o;
        return getId() == stuGrade.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public ClsDataBase getClsDataBase() {
        return clsDataBase;
    }

    public void setClsDataBase(ClsDataBase clsDataBase) {
        this.clsDataBase = clsDataBase;
    }
}
