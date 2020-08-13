package com.tedu.socket.demo02;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {
    public static void test01() {
        Socket socket = null;
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        Student s = new Student();
        s.setSid(001);
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
        test01();
    }
}
