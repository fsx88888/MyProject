package com.javaee.reflect_demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect03 {
    public static void test01() {
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
        try {
            Person per = (Person) c.newInstance();
            per.setName("zs");
            per.setAge(23);
            per.setId(12);
            System.out.println(per.getName() + "," + per.getAge());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    //操作属性
    public static void demo02(){
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
        try {
            Person per = (Person) c.newInstance();
            Field idField = c.getDeclaredField("id");
            idField.setAccessible(true);//将私有属性打开
            idField.set(per,1);
            System.out.println(per.getId());


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    //操作方法
    public static void demo03(){
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
        try {
            Person per = (Person) c.newInstance();
            Method method = c.getDeclaredMethod("privateMethod", null);
            method.setAccessible(true);
             method.invoke(per,null);


            Method method2 = c.getDeclaredMethod("privateMethod", java.lang.String.class);
            method2.setAccessible(true);
            method2.invoke(per,"test");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }  catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test01();
        demo02();
        demo03();
    }
}
