package com.tedu.collection;

import java.util.HashSet;

class A {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

class B {
    @Override
    public int hashCode() {
        return 1;
    }
}

class C {
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 2;
    }
}

public class HashSet01 {
    public static void test01() {
        HashSet hs = new HashSet();
        //重写了equals,没有重写hashCode
        A a1 = new A();
        A a2 = new A();
        hs.add(a1);
        hs.add(a2);
        //输出结果[om.tedu.collection.A@677327b6, com.tedu.collection.A@14ae5a5]
        //可见重写了equals，相等，但hashCode不相等的值可以放进去;此时在两个不同的位置存储对象
        System.out.println(hs);
    }
    public static void test02() {
        HashSet hs = new HashSet();
        //重写了hashCode,也重写equals
        B b1 = new B();
        B b2 = new B();
        hs.add(b1);
        hs.add(b2);
        //输出结果[com.tedu.collection.C@2]
        //可见重写了hashcode和equals相等;此时判定为两个相同的对象，不能存进去了
        System.out.println(hs);
    }
    public static void test03() {
        HashSet hs = new HashSet();
        //重写了hashCode,没有重写equals
        C c1 = new C();
        C c2 = new C();
        hs.add(c1);
        hs.add(c2);
        //输出结果[com.tedu.collection.B@1, com.tedu.collection.B@1]
        //可见重写了hashcode相等，但equals不相等的值可以放进去;此时是在相同的位置链式存储两个对象
        System.out.println(hs);
    }
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        //hashSet里可以放null元素
        boolean add = hs.add(null);
        //第二个null放不进去
        boolean add1 = hs.add(null);
        test01();
        test02();
        test03();

    }
}
