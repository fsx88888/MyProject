package com.tedu.socket.Demo05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;


public class URLDemo {
    public static void main(String[] args) {

        InputStream in = null;
        OutputStream out = null;
        URLConnection urlConnection = null;
        try {
            URL url = new URL("http://www.163.com");
            urlConnection = url.openConnection();
            in = urlConnection.getInputStream();
            out  =new  FileOutputStream("G:/163.txt");
            byte[] buf = new byte[10];
            int len = 0;
            while ((len = in.read(buf)) != -1) {

                out.write(buf, 0, len);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
