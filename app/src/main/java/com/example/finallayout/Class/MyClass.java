package com.example.finallayout.Class;

import java.io.Serializable;

public class MyClass implements Serializable {
    private String name;
    private String id;
    private String major;
    private String sign;
    private String lesson;
    private String base;
    private String teacher;

    public MyClass(String name, String id, String major, String sign, String lesson, String base) {
        this.name = name;
        this.id = id;
        this.major = major;
        this.sign = sign;
        this.lesson = lesson;
        this.base = base;
    }

    public MyClass(String name, String id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }

    public MyClass(){}

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


}
