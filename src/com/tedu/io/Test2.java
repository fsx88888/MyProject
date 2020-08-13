package com.tedu.io;

import java.io.FileInputStream;

import java.io.InputStreamReader;



public class Test2 {

    public static void main(String[] args) throws Exception {

        /*

         * f3, UTF-8

         * f4, GBK

         *

         * 读取,转成Unicode编码

         */

        f("g:/abc/f3", "UTF-8");

        f("g:/abc/f4", "GBK");

    }



    private static void f(

            String path, String charset) throws Exception {

        // ISR--FIS--path

        InputStreamReader in =

                new InputStreamReader(

                        new FileInputStream(path), charset);



        int c; // 00 00 xx xx, 后面两个字节,是char

        while ((c = in.read()) != -1) {

            char c1 = (char) c;//强转成char类型

            System.out.print(c1);

        }

        in.close();

    }

}