package com.tedu.io;

import java.io.*;

public class BufferReaderDemo {
    public static void test01() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("G:/abc.txt"), "gb2312"));
            StringBuffer sb = new StringBuffer();
            String lin = null;
            int len = -1;
            while ((lin = in.readLine()) != null) {
                sb.append(lin);
                sb.append("\n");
            }
            in.close();
            System.out.println(sb);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        test01();
    }
}
