package com.tedu.socket.demo03;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {
    public static void test01(int i) {
        Socket socket = null;
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Student s = new Student();
        s.setSid(i);
        s.setAge(21);
        s.setSname("fsx");
        try {
            socket = new Socket("127.0.0.1", 9190);
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) objectOutputStream.close();
                if (outputStream != null) outputStream.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            test01(i);
            System.out.println(i);
        }
    }
}
