package com.company.DataBaseAbout;

import com.company.BaseClass.Hunman.ClassTeacher;
import com.company.BaseClass.Hunman.Student;
import com.company.BaseClass.Hunman.Teacher;
import com.company.BaseClass.Lesson;
import com.company.BaseClass.LsnTime.DayTime;
import com.company.BaseClass.Schedule;
import com.company.BaseClass.StuAbout.StuClass;
import com.company.BaseClass.StuAbout.StuGrade;
import com.company.BaseClass.Subject;
import com.company.DataBaseAbout.HumanDataBases.StuDataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class LsnDataBase {

    private ArrayList<Lesson> lessonArrayList;
    private HashMap<Integer,Lesson> lessonHashMap;
    private static final LsnDataBase allLsnDataBase = new LsnDataBase();
    private static final Lesson nullLesson = new Lesson(-1);

    //------------------------------------------------------//

    //-------------构造函数----------------
    public LsnDataBase() {
        this.lessonArrayList = new ArrayList<>();
        this.lessonHashMap = new HashMap<>();
    }

    public LsnDataBase(ArrayList<Lesson> lessonArrayList, HashMap<Integer, Lesson> lessonHashMap) {
        this.lessonArrayList = lessonArrayList;
        this.lessonHashMap = lessonHashMap;
    }

    //-------------------------------------

    //-------------删除班级----------------
    //直接删除
        public void delete(Lesson lesson) {
        if(allLsnDataBase.lessonHashMap.get(lesson.getId()) != null) {
            allLsnDataBase.lessonArrayList.remove(lesson);
            allLsnDataBase.lessonHashMap.remove(lesson.getId(),lesson);
        }
        if(this.lessonHashMap.get(lesson.getId()) != null) {
            this.lessonArrayList.remove(lesson);
            this.lessonHashMap.remove(lesson.getId(),lesson);
        }
    }

    //安全删除
        public void deleteS(Lesson lesson) {
        if(lesson.getTeacher() != null) {
            lesson.getTeacher().getLessons().delete(lesson);
        }
        if(lesson.getSubject() != null){
            lesson.getSubject().getLsnDataBase().delete(lesson);
        }
        if(lesson.getSchedule() != null) {
            if(lesson.getSchedule().getLessonMap() != null) {
                Lesson[][] tem_lotsLessons = lesson.getSchedule().getLessonMap();
                for ( Lesson[] tem_lessons : tem_lotsLessons) {
                    for (Lesson tem_lesson : tem_lessons) {
                        if(tem_lesson.equals(lesson)) {
                            tem_lesson = nullLesson;
                        }
                    }
                }
            }
        }
    }

    //清空数据库
        public void deleteAll() {
        if(this.lessonArrayList != null) {
            this.lessonArrayList = null;
        }
        if(this.lessonHashMap != null) {
            this.lessonHashMap = null;
        }
    }
    //-------------------------------------

    //-------------查找班级----------------
        public ArrayList<Lesson> select(Lesson lesson, int max_id, boolean max_equ, int min_id, boolean min_equ) {
        ArrayList<Lesson> ptrLessons = new ArrayList<>(lessonArrayList);
        if(max_id != 0) {
            ArrayList<Lesson> temLessons = new ArrayList<>();
            for(Lesson tem_lesson : ptrLessons) {
                if(tem_lesson.getId() <= max_id) {
                    temLessons.add(tem_lesson);
                }
            }
            ptrLessons = temLessons;
            if(max_equ) {
                ptrLessons.removeIf(tem_lesson -> tem_lesson.getId() == max_id);
            }
        }
        if(min_id != 0) {
            ArrayList<Lesson> temLessons = new ArrayList<>();
            for(Lesson tem_lesson : ptrLessons) {
                if(tem_lesson.getId() >= min_id) {
                    temLessons.add(tem_lesson);
                }
            }
            ptrLessons = temLessons;
            if(min_equ) {
                ptrLessons.removeIf(tem_lesson -> tem_lesson.getId() == min_id);
            }
        }
        if(lesson.getId() != 0) {
            int id = lesson.getId();
            ArrayList<Lesson> temLessons = new ArrayList<>();
            temLessons.add(lessonHashMap.get(id));
            ptrLessons = temLessons;
            return ptrLessons;
        }
        if(lesson.getName() != null){
            String name = lesson.getName();
            ArrayList<Lesson> temLessons = new ArrayList<>();
            for(Lesson tem_lesson : ptrLessons) {
                if(tem_lesson.getName().equals(name)) {
                    temLessons.add(tem_lesson);
                }
            }
            ptrLessons = temLessons;
        }
        if(lesson.getRoom() != 0){
            int room = lesson.getRoom();
            ArrayList<Lesson> temLessons = new ArrayList<>();
            for(Lesson tem_lesson : ptrLessons) {
                if(tem_lesson.getRoom()==room) {
                    temLessons.add(tem_lesson);
                }
            }
            ptrLessons = temLessons;
        }
        if(lesson.getDayTime() != 0){
            int dayTime = lesson.getDayTime();
            ArrayList<Lesson> temLessons = new ArrayList<>();
            for(Lesson tem_lesson : ptrLessons) {
                if(tem_lesson.getRoom()==dayTime) {
                    temLessons.add(tem_lesson);
                }
            }
            ptrLessons = temLessons;
        }
        if(lesson.getWeekday() != 0){
            int weekDay = lesson.getWeekday();
            ArrayList<Lesson> temLessons = new ArrayList<>();
            for(Lesson tem_lesson : ptrLessons) {
                if(tem_lesson.getRoom()==weekDay) {
                    temLessons.add(tem_lesson);
                }
            }
            ptrLessons = temLessons;
        }
        if(lesson.getTeacher() != null){
            Teacher teacher = lesson.getTeacher();
            ArrayList<Lesson> temLessons = new ArrayList<>();
            for(Lesson tem_lesson : ptrLessons) {
                if(tem_lesson.getTeacher()==teacher) {
                    temLessons.add(tem_lesson);
                }
            }
            ptrLessons = temLessons;
        }
        if(lesson.getSubject() != null){
            Subject subject = lesson.getSubject();
            ArrayList<Lesson> temLessons = new ArrayList<>();
            for(Lesson tem_lesson : ptrLessons) {
                if(tem_lesson.getSubject().equals(subject)) {
                    temLessons.add(tem_lesson);
                }
            }
            ptrLessons = temLessons;
        }
        if(lesson.getSchedule() != null){
            Schedule schedule = lesson.getSchedule();
            ArrayList<Lesson> temLessons = new ArrayList<>();
            for(Lesson tem_lesson : ptrLessons) {
                if(tem_lesson.getSchedule().equals(schedule)) {
                    temLessons.add(tem_lesson);
                }
            }
            ptrLessons = temLessons;
        }
        return ptrLessons;
    }
    //------------------------------------

    //-------------添加班级----------------
    //添加个体
        public void add (Lesson lesson) {
            if(allLsnDataBase.lessonHashMap.get(lesson.getId()) == null) {
                allLsnDataBase.lessonArrayList.add(lesson);
                allLsnDataBase.lessonHashMap.put(lesson.getId(),lesson);
            }
            if(this.lessonHashMap.get(lesson.getId()) == null) {
                lessonArrayList.add(lesson);
                lessonHashMap.put(lesson.getId(),lesson);
            }
        }

    //添加全部
        public void addAll (ArrayList<Lesson> lessonArrayList) {
            for (Lesson lesson : lessonArrayList) {
                if(lessonHashMap.get(lesson.getId()) != null) {
                    lessonArrayList.add(lesson);
                    lessonHashMap.put(lesson.getId(),lesson);
                }
            }
        }

        public void addAll (LinkedList<Lesson> lessonLinkedList) {
        for (Lesson lesson : lessonLinkedList) {
            if(lessonHashMap.get(lesson.getId()) != null) {
                lessonLinkedList.add(lesson);
                lessonHashMap.put(lesson.getId(),lesson);
            }
        }
    }
    //------------------------------------

    //-------------修改班级----------------
        public void modify(Lesson lesson){
            Lesson ptrLesson = select(lesson,0,false,0,false).get(0);
            if(lesson.getName() != null || !ptrLesson.getName().equals(lesson.getName())){
                ptrLesson.setName(lesson.getName());
            }
            if(lesson.getRoom() != 0 || !(ptrLesson.getRoom() ==lesson.getRoom())){
                ptrLesson.setRoom(lesson.getRoom());
            }
            if(lesson.getDayTime() != 0 || !(ptrLesson.getDayTime() == lesson.getDayTime())){
                ptrLesson.setDayTime(lesson.getDayTime());
            }
            if(lesson.getWeekday() != 0 || !(ptrLesson.getWeekday() == lesson.getWeekday())){
                ptrLesson.setWeekday(lesson.getWeekday());
            }
            if(lesson.getTeacher() != null || !ptrLesson.getTeacher().equals(lesson.getTeacher())){
                ptrLesson.setTeacher(lesson.getTeacher());
            }
            if(lesson.getSubject() != null || !ptrLesson.getTeacher().equals(lesson.getTeacher())){
                ptrLesson.setTeacher(lesson.getTeacher());
            }


            if(lesson.getSubject() != null){
                Subject subject = lesson.getSubject();
                ArrayList<Lesson> temLessons = new ArrayList<>();
                for(Lesson tem_lesson : ptrLessons) {
                    if(tem_lesson.getSubject().equals(subject)) {
                        temLessons.add(tem_lesson);
                    }
                }
                ptrLessons = temLessons;
            }
            if(lesson.getSchedule() != null){
                Schedule schedule = lesson.getSchedule();
                ArrayList<Lesson> temLessons = new ArrayList<>();
                for(Lesson tem_lesson : ptrLessons) {
                    if(tem_lesson.getSchedule().equals(schedule)) {
                        temLessons.add(tem_lesson);
                    }
                }
                ptrLessons = temLessons;
            }
        }
//    //------------------------------------
//
//    //---------getter and setter----------
//    public static ClsDataBase getAllClsDataBase() {
//        return allClsDataBase;
//    }
}
