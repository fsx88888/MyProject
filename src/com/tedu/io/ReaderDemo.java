package com.tedu.io;

import java.io.*;

public class ReaderDemo {
    public static void test01() {
        Reader in = null;
        Writer out = null;
        try {
            in= new FileReader("G:/abc.txt");
            out= new FileWriter("G:/xyz.txt");
            char [] buff = new char[1];
            int len = -1;
            while ((len = in.read(buff)) != -1){
                out.write(buff,0,len);
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
    public static void test02(){
        try {
            Reader reader = (new InputStreamReader(
                    new FileInputStream(new File("G:/个人介绍.txt")), "gb2312"));
            char[] buf = new char[4];
            StringBuffer sb = new StringBuffer();
            int len = -1;

            while((len = reader.read(buf)) != -1){
                sb.append(buf,0,len);
            }
            reader.close();
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
    public static String get_charset(File file) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];//首先3个字节
        try {
            boolean checked = false;
            ;
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(file));
            bis.mark(0);
            int read = bis.read(first3Bytes, 0, 3);
            if (read == -1)
                return charset;
            if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE
                    && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF
                    && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8";
                checked = true;
            }
            bis.reset();
            if (!checked) {
                // int len = 0;
                int loc = 0;

                while ((read = bis.read()) != -1) {
                    loc++;
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) // 双字节 (0xC0 - 0xDF)
                            // (0x80
                            // - 0xBF),也可能在GB编码内
                            continue;
                        else
                            break;
                    } else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
            }

            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return charset;
    }
    public static void test03() {
        try {
            File dir = new File("G:/个人介绍.txt");//指定路径
            String charset = get_charset(dir);
            BufferedReader br = null;
            if (charset == "GBK") {
                InputStreamReader reader = new InputStreamReader(
                        new FileInputStream(new File("G:/个人介绍.txt")), "gb2312");
                br = new BufferedReader(reader);
                System.out.println("gb2312");
            }
            if (charset == "UTF-8") {
                br = new BufferedReader(new InputStreamReader(
                        new FileInputStream("G:/个人介绍.txt"), "UTF-8"));
                System.out.println("UTF-8");
            }
            String s;
            while ((s = br.readLine()) != null)
                System.out.println(s);
           // System.out.println(new String(s.getBytes("utf-8"),"utf-8"));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
        //test02();
        //test03();
        try {
            FileOutputStream fileReader = new FileOutputStream("G:/xyz.txt");
            PrintStream printStream = new PrintStream(fileReader);
            printStream.println("hello");
            printStream.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
