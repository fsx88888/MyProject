package com.javaee.reflect_demo;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Reflect07 {
    //通过反射动态操作一维数组  Array
    public static void test01() throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组的类型：");
        String type = scanner.nextLine();
        System.out.println("请输入数组的个数：");
        int numm = scanner.nextInt();
        Class<?> cl = Class.forName(type);
        Object o = Array.newInstance(cl, numm);
        Array.set(o,0,"zs");
        Array.set(o,1,"ls");
        Array.set(o,2,"ww");
        System.out.println(Array.get(o,0));
        System.out.println(Array.get(o,1));
        System.out.println(Array.get(o,2));
    }
    //通过反射动态操作二维数组  Array
    public static void test02() throws ClassNotFoundException {
        String type = "java.lang.Object";
        int[] num = {3,3};

        Class<?> cl = Class.forName(type);
        Object o = Array.newInstance(cl,num);//生成一个二维3*3的数组
        Object o1 = Array.get(o, 0);
        Array.set(o1,0,"zs");
        Array.set(o1,1,"ls");
        Array.set(o1,2,"ww");

        Object o2 = Array.get(o, 0);
        System.out.println(Array.get(o2,0));
        System.out.println(Array.get(o2,1));
        System.out.println(Array.get(o2,2));

    }
    public static void main(String[] args) throws ClassNotFoundException {
        test02();
    }
}
