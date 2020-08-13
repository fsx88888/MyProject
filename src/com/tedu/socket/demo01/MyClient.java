package com.tedu.socket.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class MyClient {

    public static void main(String[] args) {

        try {
            Socket socket;
            socket = new Socket("127.0.0.1", 9190);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello".getBytes());
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
