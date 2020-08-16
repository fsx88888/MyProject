package com.javaee.reflect_demo;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflect05 {
    //动态加载类名和方法
    public static void test01() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileReader("src\\com\\javaee\\reflect_demo\\properties.properties"));

        String classname = properties.getProperty("classname");
        String methodname = properties.getProperty("methodname");

        Class<?> c = null;
        try {
            c = Class.forName(classname);
            Object o = c.newInstance();
            Method method = c.getMethod(methodname);
            method.invoke(o,null);

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            System.out.println("反射路径错误");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        test01();
    }
}
