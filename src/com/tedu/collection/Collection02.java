package com.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * 集合的遍历的方式
 */
public class Collection02 {
    //用Lambda表达式遍历集合
    public static void test01(Collection col) {
        System.out.println("***用Lambda迭代元素集合***");
        col.forEach(x -> System.out.println(x));
    }

    //用Iterator迭代集合
    public static void test02(Collection col) {
        System.out.println("***用Iterator迭代集合***");
        Iterator iterator = col.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
    //使用Lambda遍历Iterator
    public static void test03(Collection col) {
        System.out.println("***使用Lambda遍历Iterator***");
        Iterator iterator = col.iterator();
        iterator.forEachRemaining(x -> System.out.println(x));
    }
    //使用ForEach遍历集合
    public static void test04(Collection col) {
        System.out.println("***使用ForEach遍历集合***");
        for(Object o : col){
            System.out.println(o);
        }
    }

    //使用Stream  遍历集合
    public static void test05(Collection col) {
        System.out.println("***使用Stream遍历集合***");
        Stream stream = col.stream();
        stream.forEach(x -> System.out.println(x));
    }
    public static void main(String[] args) {
        Collection books = new ArrayList();
        books.add("轻量级JAVAEE企业实战");
        books.add("JAVA疯狂讲义");
        books.add("疯狂Android讲义");
        test01(books);
        test02(books);
        test03(books);
        test04(books);
        test05(books);
    }
}
