package com.company.DataBaseAbout;

import com.company.BaseClass.Hunman.Student;
import com.company.BaseClass.Lesson;
import com.company.DataBaseAbout.HumanDataBases.StuDataBase;
import com.company.BaseClass.Hunman.ClassTeacher;
import com.company.BaseClass.Schedule;
import com.company.BaseClass.StuAbout.StuClass;
import com.company.BaseClass.StuAbout.StuGrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ClsDataBase {
    private ArrayList<StuClass> stuClassArrayList;
    private HashMap<Integer,StuClass> stuClassHashMap;
    private static final ClsDataBase allClsDataBase = new ClsDataBase();
    private static final StuClass nullStuClass = new StuClass(-1);

    //------------------------------------------------------//

    //-------------构造函数----------------
    public ClsDataBase() {
        this.stuClassArrayList = new ArrayList<StuClass>();
        this.stuClassHashMap = new HashMap<>();
    }

    public ClsDataBase(ArrayList<StuClass> stuClassArrayList, HashMap<Integer, StuClass> stuClassHashMap) {
        this.stuClassArrayList = stuClassArrayList;
        this.stuClassHashMap = stuClassHashMap;
    }
    //-------------------------------------

    //-------------删除数据库---------------
    //清空数据库
    public void delete() {
        if(this.stuClassArrayList != null) {
            this.stuClassArrayList = null;
        }
        if(this.stuClassHashMap != null) {
            this.stuClassHashMap = null;
        }
    }

    public void delete() {
        if(this.stuClassArrayList != null) {
            this.stuClassArrayList = null;
            for(StuClass stuClass : )
        }
        if(this.stuClassHashMap != null) {
            this.stuClassHashMap = null;
        }
    }

    //-------------删除班级----------------
    //直接删除
    public void deleteCls(StuClass stuClass) {
        if(allClsDataBase.stuClassHashMap.get(stuClass.getId()) != null) {
            allClsDataBase.stuClassArrayList.remove(stuClass);
            allClsDataBase.stuClassHashMap.remove(stuClass.getId(),stuClass);
        }
        if(this.stuClassHashMap.get(stuClass.getId()) != null) {
            this.stuClassArrayList.remove(stuClass);
            this.stuClassHashMap.remove(stuClass.getId(),stuClass);
        }
    }

    //安全删除
    public void deleteClsS(StuClass stuClass) {
        if(stuClass.getStuGrade() != null) {
            delete(stuClass);
        }
        if(stuClass.getStudents() != null){
            for( Student student : stuClass.getStudents().getStudentArrayList()) {
                student.setStuClass(nullStuClass);
            }
        }
        if(stuClass.getClassTeacher() != null) {
            stuClass.getClassTeacher().setTeaClass(nullStuClass);
        }
        if(stuClass.getSchedule() != null) {
            stuClass.getSchedule().setStuClass(nullStuClass);
            if(stuClass.getSchedule().getLessonMap() != null) {
                Lesson[][] tem_lotsLessons = stuClass.getSchedule().getLessonMap();
                for ( Lesson[] tem_lessons : tem_lotsLessons) {
                    for (Lesson lesson : tem_lessons) {
                        lesson.setStuClass(nullStuClass);
                    }
                }
            }
        }
    }

    //-------------------------------------

    //-------------查找班级----------------
    public ArrayList<StuClass> select(StuClass stuClass, int max_id, boolean max_equ, int min_id, boolean min_equ) {
        ArrayList<StuClass> ptrStuClasses = new ArrayList<>(stuClassArrayList);
        if(max_id != 0) {
            ArrayList<StuClass> temStuClasses = new ArrayList<>();
            for(StuClass tem_stuClass : ptrStuClasses) {
                if(tem_stuClass.getId() <= max_id) {
                    temStuClasses.add(tem_stuClass);
                }
            }
            ptrStuClasses = temStuClasses;
            if(max_equ) {
                ptrStuClasses.removeIf(tem_stuClass -> tem_stuClass.getId() == max_id);
            }
        }
        if(min_id != 0) {
            ArrayList<StuClass> temStuClasses = new ArrayList<>();
            for(StuClass tem_stuClass : ptrStuClasses) {
                if(tem_stuClass.getId() >= min_id) {
                    temStuClasses.add(tem_stuClass);
                }
            }
            ptrStuClasses = temStuClasses;
            if(min_equ) {
                ptrStuClasses.removeIf(tem_stuCless -> tem_stuCless.getId() == min_id);
            }
        }
        if(stuClass.getId() != 0) {
            int id = stuClass.getId();
            ArrayList<StuClass> temStuClasses = new ArrayList<>();
            temStuClasses.add(stuClassHashMap.get(id));
            ptrStuClasses = temStuClasses;
            return ptrStuClasses;
        }
        if(stuClass.getStuGrade() != null){
            StuGrade stuGrade = stuClass.getStuGrade();
            ArrayList<StuClass> temStuClasses = new ArrayList<>();
            for(StuClass tem_stuClass : ptrStuClasses) {
                if(tem_stuClass.getStuGrade().equals(stuGrade)) {
                    temStuClasses.add(tem_stuClass);
                }
            }
            ptrStuClasses = temStuClasses;
        }
        if(stuClass.getStudents() != null){
            StuDataBase students = stuClass.getStudents();
            ArrayList<StuClass> temStuClasses = new ArrayList<>();
            for(StuClass tem_stuClass : ptrStuClasses) {
                if(tem_stuClass.getStudents().supEquals(students)) {
                    temStuClasses.add(tem_stuClass);
                }
            }
            ptrStuClasses = temStuClasses;
        }
        if(stuClass.getClassTeacher() != null){
            ClassTeacher classTeacher = stuClass.getClassTeacher();
            ArrayList<StuClass> temStuClasses = new ArrayList<>();
            for(StuClass tem_stuClass : ptrStuClasses) {
                if(tem_stuClass.getClassTeacher().equals(classTeacher)) {
                    temStuClasses.add(tem_stuClass);
                }
            }
            ptrStuClasses = temStuClasses;
        }
        if(stuClass.getSchedule() != null){
            Schedule schedule = stuClass.getSchedule();
            ArrayList<StuClass> temStuClasses = new ArrayList<>();
            for(StuClass tem_stuClass : ptrStuClasses) {
                if(tem_stuClass.getSchedule().equals(schedule)) {
                    temStuClasses.add(tem_stuClass);
                }
            }
            ptrStuClasses = temStuClasses;
        }
        return ptrStuClasses;
    }
    //------------------------------------

    //-------------添加班级----------------
    //添加个体
    public void add (StuClass stuClass) {
        if(allClsDataBase.stuClassHashMap.get(stuClass.getId()) == null) {
            allClsDataBase.stuClassArrayList.add(stuClass);
            allClsDataBase.stuClassHashMap.put(stuClass.getId(),stuClass);
        }
        if(this.stuClassHashMap.get(stuClass.getId()) == null) {
            stuClassArrayList.add(stuClass);
            stuClassHashMap.put(stuClass.getId(),stuClass);
        }
    }

    //添加全部
    public void addAll (ArrayList<StuClass> stuClassArrayList) {
        for (StuClass tem_stuClass : stuClassArrayList) {
            if(stuClassHashMap.get(tem_stuClass.getId()) != null) {
                stuClassArrayList.add(tem_stuClass);
                stuClassHashMap.put(tem_stuClass.getId(),tem_stuClass);
            }
        }
    }

    public void addAll (LinkedList<StuClass> stuClassLinkedList) {
        for (StuClass tem_stuClass : stuClassLinkedList) {
            if(stuClassHashMap.get(tem_stuClass.getId()) != null) {
                stuClassLinkedList.add(tem_stuClass);
                stuClassHashMap.put(tem_stuClass.getId(),tem_stuClass);
            }
        }
    }
    //------------------------------------

    //-------------修改班级----------------
    public void modify(StuClass stuClass){
        StuClass ptrClass = select(stuClass,0,false,0,false).get(0);
        if(stuClass.getStuGrade() != null || !ptrClass.getStuGrade().equals(stuClass.getStuGrade())){
            ptrClass.getStuGrade().getClsDataBase().delete(ptrClass);
            stuClass.getStuGrade().getClsDataBase().add(ptrClass);
            ptrClass.setStuGrade(stuClass.getStuGrade());
        }
        if(stuClass.getClassTeacher() != null || !ptrClass.getClassTeacher().equals(stuClass.getClassTeacher())){
            stuClass.getClassTeacher().setTeaClass(ptrClass);
            ptrClass.setClassTeacher(stuClass.getClassTeacher());
        }
        if(stuClass.getSchedule() != null || !ptrClass.getSchedule().equals(stuClass.getSchedule())){
            ptrClass.setSchedule(stuClass.getSchedule());
        }
    }
    //------------------------------------

    //---------getter and setter----------
    public static ClsDataBase getAllClsDataBase() {
        return allClsDataBase;
    }
}
