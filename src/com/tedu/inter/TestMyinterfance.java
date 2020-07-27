package com.tedu.inter;

public class TestMyinterfance implements MyInterface {
    @Override
    public void eat3() {  //可以对接口的默认方法进行重写
        System.out.println("son eat3");
    }

    @Override
    public void eat() {
        System.out.println("son eat");
    }

    public static void main(String[] args) {

        TestMyinterfance test = new TestMyinterfance();
        MyInterface test2 = (MyInterface) test;

        //调用接口里的常量，自能类名来调用；不能用多态的形式调用
        System.out.println(MyInterface.MY_NUM);

        test.eat();
        test2.eat();

        MyInterface.eat2(); //接口的静态方法只能类名.调用

        test.eat3();  //接口实现类调用默认方法
        test2.eat3();//
    }
}
