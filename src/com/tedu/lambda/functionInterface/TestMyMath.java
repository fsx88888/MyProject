package com.tedu.lambda.functionInterface;

public class TestMyMath {
    public static void test2(){
        MyMath math = (a,b) -> a+b;
        System.out.println(math.add(1,3));
    }
    public static void main(String[] args) {
        test2();

    }
}
