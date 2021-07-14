package com.dgong.test;

import java.util.Date;

public class Person {
    private String name;
    private int age;
    private Date brithday;

    public Person() {
    }
    public Person(String name, int age, Date brithday) {
        this.name = name;
        this.age = age;
        this.brithday = brithday;
    }
    public String disPlay() {
        return this.name + ":" + this.age + ":" + this.brithday.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }
}
