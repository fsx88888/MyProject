package com.tedu.io;

import java.io.*;

public class InputStreamDemo {
    public static void test01() {
        try {
            InputStream inputStream = new FileInputStream("G:/abc.txt");
            //获取不同系统下的路径分隔符号用File.separator或者System.getProperty("file.separator")
            InputStream inputStream1 = new FileInputStream(new File("G:" + File.separator + "abc.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void test02() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in= new FileInputStream("G:/abc.txt");
            out= new FileOutputStream("G:/xyz.txt");
            byte [] bytes = new byte[10];
            int read = -1;
            while ((read = in.read(bytes)) != -1){
                out.write(bytes,0,read);
            }
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(out != null)
                    out.close();
                if(in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                in = null;
                out = null;
            }
        }
    }

    public static void main(String[] args) {
        test01();
        test02();
    }
}
