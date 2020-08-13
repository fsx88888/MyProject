package com.tedu.thread;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Scanner;



public class MyThread {

    public static void main(String[] args) {

        T1 t1 = new T1();

        t1.start();



        Thread t2 = new Thread() {

            @Override

            public void run() {

                System.out.println("按回车打断t1线程");

                new Scanner(System.in).nextLine();

                //main线程执行这行代码,打断t1线程

                t1.interrupt();

                System.out.println("捅了一下t1");

            }

        };

        //设置成后台线程,不影响虚拟机退出

        t2.setDaemon(true);



        t2.start();

    }


    static class T1 extends Thread{

        @Override

        public void run() {

            SimpleDateFormat sdf =

                    new SimpleDateFormat("HH:mm:ss");

            for(int i=0;i<10;i++) {

                // 是 util 包, 不是 sql 包

                String s = sdf.format(new Date());

                System.out.println(s);

                //暂停1000毫秒

                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                    System.out.println(

                            "才睡着,不许打扰我,我很困,蔡徐坤");

                    break;

                }

            }

        }

    }


}