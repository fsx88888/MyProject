package com.tedu.thread;

public class MyThread02 {

    public static void main(String[] args) throws InterruptedException {

        // 1000万内的质数数量

        // 2,3,5,7,11,13,17,19,23....



        System.out.println("--单线程---------------");

        f1();

        System.out.println("--5个线程---------------");

        f2();

    }


    private static void f1() throws InterruptedException {

        long t = System.currentTimeMillis();



        T1 t1 = new T1(0, 10000000);

        t1.start();



        //取结果之前,让main线程暂停,

        //等待t1执行结束,产生结果

        t1.join();



        //取结果

        int c = t1.count;



        t = System.currentTimeMillis()-t;

        System.out.println("时间: "+t);

        System.out.println("质数: "+c);

    }


    private static void f2() throws InterruptedException {

        long t = System.currentTimeMillis();



        //创建并启动5个线程,线程实例保存在数组中

        T1[] a = new T1[5];

        for (int i = 0; i < a.length; i++) {

            a[i] = new T1(i*2000000,(i+1)*2000000);

            a[i].start();

        }



        int c=0;

        for (int i = 0; i < a.length; i++) {

            //等待这个线程结束后,再取它的计算结果

            a[i].join();

            c += a[i].count;

        }





        t = System.currentTimeMillis()-t;

        System.out.println("时间: "+t);

        System.out.println("质数: "+c);

    }



    static class T1 extends Thread{

        int from;//包含

        int to;//不包含

        int count;//计数变量

        public T1(int from, int to) {

            //2是第一个质数,但2不好判断,

            //我们不判断2,从3开始向后找质数

            if (from<=2) {

                from = 3;

                count = 1;

            }

            this.from = from;

            this.to = to;

        }





        @Override

        public void run() {

            //i循环从 from 到 < to

            for (int i = from; i <to; i++) {

                //判断i的值是不是质数

                if (isPrime(i)) {

                    count++;

                }

            }

        }

        private boolean isPrime(int i) {

            //在 [2, i开方+1) 范围, 找能把i整除的值

            double m = 1+Math.sqrt(i);

            for (int j = 2; j < m; j++) {

                if (i%j==0) {

                    return false;

                }

            }

            return true;

        }

    }

}