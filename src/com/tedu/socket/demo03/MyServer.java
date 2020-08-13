package com.tedu.socket.demo03;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void test01() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        try {
            serverSocket = new ServerSocket(9190);
            while (true) {
                accept = serverSocket.accept();
                SocketThread socketThread = new SocketThread(accept);
                socketThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
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
