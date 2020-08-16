package com.javaee.reflect_demo;

public class Reflect01 {
    //用反射获取类
    public static void test01(){
        try {
            Class<?> c = Class.forName("com.javaee.reflect_demo.Reflect01");
            System.out.println(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<Reflect01> c2 = Reflect01.class;
        System.out.println(c2);

        Reflect01 ref = new Reflect01();
        Class<? extends Reflect01> c3 = ref.getClass();
        System.out.println(c3);
    }
    //用反射获取方法
    public static void test03(){
        Class<?> c = null;
        try {
          c = Class.forName("com.javaee.reflect_demo.Person");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        test01();


    }
}
