package com.javaee.reflect_demo;

public class Person implements MyIInterface,MyIInterface02{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    private void privateMethod(){
        System.out.println("privateMethod");
    }
    private void privateMethod(String str){
        System.out.println("privateMethod:    "+str);
    }
    public static void staticMethod(){
        System.out.println("staticMethod..");
    }
    private int id;
    private String name;
    private int age;
    public String desc;

    @Override
    public void interfaceMethod() {
        System.out.println("interfaceMathod...");
    }

    @Override
    public void interfaceMethod02() {
        System.out.println("interfaceMathod02...");
    }

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }


    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private Person(Integer id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    private Person(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person(new Integer(1).intValue(), "zs", "ls");
    }
}
