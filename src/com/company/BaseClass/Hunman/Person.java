package com.company.BaseClass.Hunman;

public abstract class Person {
    protected static int number;
    protected String name;
    protected boolean gender;//0--male 1--female
    protected int age;

    //------------------------------------------------------//


    public Person() {
    }

    public Person(String name, boolean gender, int age) {
        setNumber(getNumber() + 1);
        this.setName(name);
        this.setGender(gender);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Person.number = number;
    }
}
