package com.company.DataBaseAbout.HumanDataBases;

import com.company.BaseClass.Hunman.ClassTeacher;
import com.company.BaseClass.Hunman.Student;
import com.company.BaseClass.Schedule;
import com.company.BaseClass.Score;
import com.company.BaseClass.StuAbout.StuClass;
import com.company.BaseClass.StuAbout.StuGrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class StuDataBase {
    private static StuDataBase allStuDataBase;
    private ArrayList<Student> studentArrayList;
    private HashMap<Integer , Student> studentHashMap;
    private static final Student nullStudent = new Student(-1);
    //------------------------------------------//

    //无参构造
    public StuDataBase() {
        studentArrayList = new ArrayList<>();
        studentHashMap = new HashMap<>();
    }

    //含参构造
    public StuDataBase(ArrayList<Student> studentArrayList, HashMap<Integer, Student> studentHashMap) {
        this.studentArrayList = studentArrayList;
        this.studentHashMap = studentHashMap;
    }

    //返回学生数量
    public int size() {
        return studentArrayList.size();
    }

    //按照属性查找学生
    public ArrayList<Student> select(Student ptrStudent) {

        int id = ptrStudent.getId();
        StuGrade stuGrade = ptrStudent.getStuGrade();
        StuClass stuClass = ptrStudent.getStuClass();
        ClassTeacher classTeacher = ptrStudent.getClassTeacher();
        Schedule schedule = ptrStudent.getSchedule();
        Score score = ptrStudent.getScoreList();

        ArrayList<Student> ptrStudents = studentArrayList;

        if(id != 0) {
            ArrayList<Student> temStudents = new ArrayList<>();
            temStudents.add(studentHashMap.get(id));
            ptrStudents = temStudents;
            return ptrStudents;
        }
        if(stuGrade != null){
            ArrayList<Student> temStuClasses = new ArrayList<>();
            for(Student student : ptrStudents) {
                if(student.getStuGrade().equals(stuGrade)) {
                    temStuClasses.add(student);
                }
            }
            ptrStudents = temStuClasses;
        }
        if(stuClass != null){
            ArrayList<Student> temStuClasses = new ArrayList<>();
            for(Student student : ptrStudents) {
                if(student.getStuClass().equals(stuClass)) {
                    temStuClasses.add(student);
                }
            }
            ptrStudents = temStuClasses;
        }
        if(classTeacher != null){
            ArrayList<Student> temStuClasses = new ArrayList<>();
            for(Student student : ptrStudents) {
                if(student.getClassTeacher().equals(classTeacher)) {
                    temStuClasses.add(student);
                }
            }
            ptrStudents = temStuClasses;
        }
        if(schedule != null){
            ArrayList<Student> temStuClasses = new ArrayList<>();
            for(Student student : ptrStudents) {
                if(student.getSchedule().equals(schedule)) {
                    temStuClasses.add(student);
                }
            }
            ptrStudents = temStuClasses;
        }
        if(score != null){

        }
        return ptrStudents;
    }

    //添加学生
    public boolean add (Student student) {
        return studentArrayList.add(student) || studentHashMap.put(student.getId(),student) == null;
    }

    //低级相等（存在相同学生即可，用于同级数据库比较）
    public boolean supEquals(Object o) {
        if (this == o) return true;
        if (o == null || Student.class != o.getClass()) return false;
        Student that = (Student) o;
        return studentArrayList.contains(that);
    }

    //所有学生相等
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StuDataBase that = (StuDataBase) o;
        return Objects.equals(studentArrayList, that.studentArrayList) && Objects.equals(studentHashMap, that.studentHashMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentArrayList, studentHashMap);
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public HashMap<Integer, Student> getStudentHashMap() {
        return studentHashMap;
    }

    public void setStudentHashMap(HashMap<Integer, Student> studentHashMap) {
        this.studentHashMap = studentHashMap;
    }
}
