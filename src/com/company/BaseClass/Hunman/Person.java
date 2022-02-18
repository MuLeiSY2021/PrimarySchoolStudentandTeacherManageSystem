package com.company.BaseClass.Hunman;

public abstract class Person {
    protected static int number;
    protected String name;
    protected boolean gender;//0--male 1--female
    protected int age;

    //------------------------------------------------------//
    //------删除成员------//
    public void delete() {
        name = null;
        gender = false;
        age = 0;
    }
    //-------------------//

    //------查找成员------//

    public static int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    //-------------------//

    //------修改成员------//

    public static void setNumber(int number) {
        Person.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //-------------------//

    //------插入成员------//
    public Person() {
    }

    public Person(String name, boolean gender, int age) {
        setNumber(getNumber() + 1);
        this.setName(name);
        this.setGender(gender);
        this.setAge(age);
    }
    //-------------------//
}
