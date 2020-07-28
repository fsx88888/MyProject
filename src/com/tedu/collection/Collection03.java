package com.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * Java8新增的Predicate操作集合（removeIf方法）
 */
public class Collection03 {
    public static void test01(Collection coll) {
        coll.removeIf(x -> ((String) x).length() < 10);
        System.out.println(coll);
    }

    public static void test02(Collection col) {
        //统计含有“轻量“字符串图书的数量
        System.out.println(test03(col,(x) -> ((String)x).contains("轻量")));
        //统计含有“Java“字符串图书的数量
        System.out.println(test03(col,(x) -> ((String)x).contains("JAVA")));
        //统计字符串长度小于10图书的数量
        System.out.println(test03(col,(x) -> ((String)x).length() <10));
    }

    public static int test03(Collection col, Predicate pr) {
        int total = 0;
        for (Object o : col) {
            if(pr.test(o)){
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Collection books = new ArrayList();
        books.add("轻量级JAVAEE企业实战");
        books.add("JAVA疯狂讲义");
        books.add("疯狂Android讲义");
        books.add("疯狂IOS讲义");
        books.add("疯狂Ajax讲义");
       // test01(books);
        test02(books);

    }
}
