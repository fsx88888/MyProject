package com.tedu.io;

import java.io.*;



public class Test1 {

    public static void main(String[] args) throws Exception {

        /*

         * Unicode编码表 0 到 65535

         * \u4e00 到 \u9fa5 是中文字符范围

         * 20902个中文字符

         *

         * OSW--FOS--f3 保存UTF-8编码

         * OSW--FOS--f4 保存GBK编码

         */

        f("G:/abc/f3", "UTF-8");

        f("G:/abc/f4", "GBK");

    }
    /*

     * 字符编码   encoding

     * 字符集 charset

     */

    private static void f(

            String path,

            String charset) throws Exception {

        //字符由OSW做编码转换

        //转码的结构交给FOS向文件输出

        OutputStreamWriter out =

                new OutputStreamWriter(

                        new FileOutputStream(new File(path)),charset);//需要指定转换的编码

        int count = 0;

        for (char i = '\u4e00'; i <='\u9fa5'; i++) {

            out.write(i);

            count++;

            if (count == 30) {//每30个中文添加换行

                //windows换行用 \r\n

                //其他系统只用 \n

                out.write('\r');

                out.write('\n');

                count=0;

            }

        }

        out.close();

    }

}