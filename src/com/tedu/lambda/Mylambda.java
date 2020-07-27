package com.tedu.lambda;

public class Mylambda {
    public static void test1() {
        new Thread( () -> { System.out.println("hello world"); }).start();
    }

    public static void main(String[] args) {
        test1();
    }
}
