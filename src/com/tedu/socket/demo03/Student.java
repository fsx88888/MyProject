package com.tedu.socket.demo03;

import java.io.Serializable;

public class Student implements Serializable {
    private int sid;
    private String sname;
    private int age;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

    }
}
