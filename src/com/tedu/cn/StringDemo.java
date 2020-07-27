package com.tedu.cn;

public class StringDemo {
    public static void main(String[] args) {
       //如果对字符串需要频繁的修改，则不建议使用String类，而需要使用StringBuffer类
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        String str4 = new String("hello");
        String str5 = new String("hello");
        //使用字符串时，先在常量池中找，如果有则使用，如果无，则创建后放入常量池，并使用；
        //栈放 基本类型,引用类型； 堆放对象的实例   方法区里有常量池
        System.out.println("str1 == str2\t" + (str1 == str2));
        System.out.println("str3 == str4\t" + (str3 == str4));
        System.out.println("str1 == str4\t" + (str1 == str4));
        //字符串，如果直接使用字面量String str = "abc",则从常量池中找；如果使用new则从堆里找（而堆又从常量池中找）
        //字符串如果new 创建，则必然会直接指向堆中对象如果new之后，任然想从常量池中获取，则需要使用inter（）
        String str6 = new String("hello");
        str6 = str6.intern();//从使其指向 常量池
        System.out.println("str1 == str6\t" + (str1 == str6));


    }
}
