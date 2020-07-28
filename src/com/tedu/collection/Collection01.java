package com.tedu.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

class Student{
    private String name = null;
    private int age = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**
 * 集合的基本用法
 */
class Collection01 {

    public static void main(String[] args) {
        //add(E e)
        Collection col1 = new ArrayList();
        col1.add("a");
        col1.add("b");
        col1.add("c");
        System.out.println(col1); //接口重写了toString（）方法
        //创建三个学生
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(12);
        Student stu2 = new Student();
        stu2.setName("李四");
        stu2.setAge(13);
        Student stu3 = new Student();
        stu1.setName("王五");
        stu1.setAge(14);
        //clear()  清空所有元素
        col1.clear();
        //向集合增加三个学生
        col1.add(stu1);
        col1.add(stu2);
        col1.add(stu3);
        System.out.println(col1);
        //求集合元素个数size（)
        System.out.println(col1.size());
        //addAll(Collection<? extends E> c)  向一个集合中加入另一个集合
        Collection col2= new ArrayList();
        col2.add("a");
        col2.add("b");
        col2.add("c");
        col2.add(stu1);
        boolean bool = col1.addAll(col2);
        System.out.println(bool);
        //判断一个集合是否包含另一个集合
        boolean bool2 = col1.containsAll(col2);
        //判断此集合是否为空
        boolean empty = col1.isEmpty();
        //仅保留指定集合的内容,相同的部分保留
        Student stu4 = new Student();
        stu4.setName("赵六");
        stu4.setAge(16);
        col2.add(stu4);
        System.out.println(col1);
        System.out.println(col2);
        boolean retainAll = col1.retainAll(col2);
        System.out.println(retainAll);
        System.out.println(col1.toString());
        //将集合变成数组
        Object[] objects = col1.toArray();
        System.out.println("将集合转为u数组" +Arrays.toString(objects));
    }
}
