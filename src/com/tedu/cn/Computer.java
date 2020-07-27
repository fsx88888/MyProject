package com.tedu.cn;

public class Computer {

    String name =null;
    byte score = 0;
    public  void showFist(byte randNumb){

        System.out.println(randNumb);
        switch (randNumb) {
            case 1 :
                System.out.println("电脑出的是    石头");
                break;
            case 2 :
                System.out.println("电脑出的是    剪子");
                break;
            case 3 :
                System.out.println("电脑出的是    石头");
                break;
        }
    }
}
