package com.tedu.io;

import java.io.*;
//二进制流
public class DataInputStreamDemo {
    public static void test02() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in= new DataInputStream(new FileInputStream("G:/abc.txt"));
            out= new DataOutputStream(new FileOutputStream("G:/xyz.txt"));
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
        test02();
    }
}
