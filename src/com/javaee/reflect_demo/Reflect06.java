package com.javaee.reflect_demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Reflect06 {
    //反射可以越过泛型检查
    public static void test01() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        ArrayList<Integer> list = new ArrayList<>();
        Class<? extends ArrayList>  c = list.getClass();
        Method add = c.getMethod("add",Object.class);
        add.invoke(list,"zs");
        System.out.println(list);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        test01();
    }
}
