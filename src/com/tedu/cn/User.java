package com.tedu.cn;

import java.util.Scanner;

public class User {
    String name = null;
    byte score = 0;
    public  int showFist(){
        System.out.println("请你选择：1：石头  2：剪子 3：布");
       byte userFist  =new Scanner(System.in).nextByte();
        switch (userFist) {
            case 1 :
                System.out.println("您出的是    石头");
                break;
            case 2 :
                System.out.println("您出的是    剪子");
                break;
            case 3 :
                System.out.println("您出的是    石头");
                break;
            default:
                System.out.println("输入错误！！！");
                break;
        }
    return userFist;
    }

}
