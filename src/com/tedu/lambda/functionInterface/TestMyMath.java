package com.tedu.lambda.functionInterface;


import java.util.function.Function;

public class TestMyMath {
    public static void test01(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run.....");
            }
        }).start();
    }
    //方式一： 函数式接口  引用名 = lambda表达式
    public static void test02(){
        new Thread(() -> System.out.println("run...")).start();
    }

    public static void test03(){
        MyMath math = (a,b) -> a+b;
        System.out.println(math.add(1,3));
    }

    //方式二：将lambda表达式代表的函数式接口，作为一个方法参数的存在
    public static void test06(){
        String str = upper((x) -> x.toUpperCase(), "hello");
        System.out.println(str);
    }
    public static String upper(Function<String,String> fun , String str){
       return fun.apply(str);
    }
    public static void main(String[] args) {
        test01();
        test06();
    }
}
