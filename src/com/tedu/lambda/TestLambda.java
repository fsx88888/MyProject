package com.tedu.lambda;

import java.util.function.Predicate;

public class TestLambda {
    public static void main(String[] args) {
        Predicate<Integer> p1 = (num)-> {return num < 10;};
        //其等同于下面表达式；只有一个参数可以省区（），并且有返回值可以省区return和{}
        Predicate<Integer> p2 = num -> num < 10;
        System.out.println(p1.test(3));
    }
}
