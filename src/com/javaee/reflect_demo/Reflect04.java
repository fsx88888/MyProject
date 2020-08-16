package com.javaee.reflect_demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflect04 {
    //操作构造方法
    public static void demo01(){
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
//获取公共构造方法
        Constructor<?>[] constructors = c.getConstructors();
        for (Constructor con : constructors){
            System.out.println(con);
        }
    }
    public static void demo02(){
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
//获取本类所有构造方法
        Constructor<?>[] constructors = c.getDeclaredConstructors();
        for (Constructor con : constructors){
            System.out.println(con);
        }
    }
    public static void demo03(){
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
//获取本指定构造方法
        try {
            Constructor<?> constructor = c.getDeclaredConstructor(Integer.class,String.class, String.class);
            constructor.setAccessible(true);
            Person o = (Person)constructor.newInstance(1, "zs", "hello");
            System.out.println(o.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //demo01();
        //demo02();
        demo03();

    }
}
