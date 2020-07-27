package com.tedu.cn;

import java.util.Scanner;

public class Game {
    User user = null;
    Computer computer = null;
    Scanner input = new Scanner(System.in);


    //初始化：设置自己的名字 对手的名字 积分0;
    public  void init() {
        user = new User();
        computer = new Computer();

        System.out.println("请输入自己的名字：");
        user.name = input.nextLine();
        user.score = 0;

        System.out.println("请选择对手：1：张三  2：李四  3：王五");
        byte number = input.nextByte();
        switch (number) {
            case 1:
                computer.name = "张三";
                break;
            case 2:
                computer.name = "李四";
                break;
            case 3:
                computer.name = "王五";
                break;
        }
        System.out.println("您的对手TA是：" + computer.name);
        computer.score = 0;

    }


    public  void start() {
        String flag = null;
        int randNumb =0;
        int userFist ;
        do {

             userFist = user.showFist();
            randNumb = (int)(Math.random()*3+1);

        if((userFist == 1 && randNumb == 2  )||(userFist == 2 && randNumb == 3)||(userFist == 3 && randNumb ==1)) {
            System.out.println("本局您赢了！！");
            user.score++;
        }
        else if((userFist == 2 && randNumb == 1 )||(userFist == 3 && randNumb == 2)||(userFist == 1 && randNumb ==3)) {
            System.out.println("本局您输了！！");
            computer.score++;
        }
        else System.out.println("本局平局");

            System.out.println("是否继续：  是（y） 否（其他）");
             flag = input.next();

        }while ( "y".equals(flag));

        calcResult(user.score,computer.score);
    }

    public void calcResult(byte userScore,byte computerScore) {
        System.out.println(user.name+"\t得分"+userScore);
        System.out.println(computer.name+"\t得分"+computerScore);
        if(userScore > computerScore) System.out.println("恭喜您，您赢了");
        if(userScore < computerScore) System.out.println("很遗憾，您输了");
        if(userScore == computerScore) System.out.println("再接再厉，平局");
    }

    public static void main(String[] args) {

        Game game = new Game();
        game.init();
        game.start();

    }
}
