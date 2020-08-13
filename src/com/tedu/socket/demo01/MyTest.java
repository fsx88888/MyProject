package com.tedu.socket.demo01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class MyTest {
    public static void test01(){
        try {
            ServerSocket serverSocket = new ServerSocket(9190);
            Socket accept = serverSocket.accept();//当有客户端链接服务端时触发，不然继续等待
            InputStream inputStream = accept.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader buf = new BufferedReader(reader);
            String info = null;
            while((info = buf.readLine()) != null){
                System.out.println(info);
            }

            buf.close();
            inputStream.close();
            accept.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        test01();
    }
}

