package com.tedu.socket.demo02;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void test01() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            serverSocket = new ServerSocket(9190);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            Object o = objectInputStream.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) objectInputStream.close();
                if (inputStream != null) inputStream.close();
                if (accept != null) accept.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test01();

    }
}
