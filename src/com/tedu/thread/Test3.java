package com.tedu.thread;

public class Test3 {

    public static void main(String[] args) {

        T1 t1 = new T1();

        /*     ++        ++        ++

         * t1.add(), t1.add(), t1.add()....

         *     ++        ++        ++

         */

        t1.start();



        /*

         * t1.get(), t1.get(), t1.get()....

         */

        //main线程

        T1 t2 = new T1();

        while (true) {

            int i = t2.get();

            if (i%2==1) {

                System.out.println("["+i+"]");



                System.exit(0);//退出虚拟机

            }

        }

    }


    static class T1 extends Thread {

        static int i;

        public static synchronized void add() {

            i++;
            System.out.println(i);

        }

        public static synchronized int get() {

            return i;

        }

        @Override

        public void run() {

            while(true) {

                add();

            }

        }

    }


}