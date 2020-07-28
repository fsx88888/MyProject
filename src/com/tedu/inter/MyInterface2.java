package com.tedu.inter;

public interface MyInterface2 {

    //接口里可以定义常量 必须是  public static final修饰
    public static final int MY_NUM = 99; //建议常量这么写
    int b = 5;//其自动补全public static final  修饰

    //普通方法必须是抽象方法
    public void   eat4();
    //可以定义 static和default修饰的方法
    public static  void  eat5() {
        System.out.println("est2");
    }
    default void  eat6() {
        System.out.println("est3");
    }

}
