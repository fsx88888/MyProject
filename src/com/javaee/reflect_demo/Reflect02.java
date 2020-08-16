package com.javaee.reflect_demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect02 {
    public static void test01() {
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
        //可以获取本类的公开的方法，继承父类的方法；
        Method[] methods = c.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }

    public static void test02() {
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
        //获取所有的接口
        Class<?>[] interfaces = c.getInterfaces();
        for (Class<?> cl : interfaces) {
            System.out.println(cl);
        }
    }

    public static void test03() {
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
        //获取父类
        Class<?> superclass = c.getSuperclass();
        System.out.println(superclass);
    }

    public static void test04() {
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
        //获取构造方法
        Constructor<?>[] constructors = c.getConstructors();
        for (Constructor<?> con : constructors) {

            System.out.println(con);
        }
    }

    public static void test05() {
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
        //获取所有公共属性
        Field[] fields = c.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
    }

    public static void test06() {
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
        //获取当前类所有的方法（1.只能是当前类，2忽略访问修饰符限制）
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
        //获取当前类所有的属性（1.只能是当前类，2忽略访问修饰符限制）
        Field[] declaredFields = c.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
    }
    public static void test07(){
        Class<?> c = null;
        try {
            c = Class.forName("com.javaee.reflect_demo.Person");
        } catch (ClassNotFoundException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        }
        try {
            Object instance = c.newInstance();
           Person p = (Person)instance;
           p.interfaceMethod02();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //test01();
        //test02();
        //test03();
        //test04();
        //test05();
        //test06();
        test07();

    }
}
