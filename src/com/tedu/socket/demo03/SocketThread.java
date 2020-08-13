package com.tedu.socket.demo03;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketThread extends Thread {


   private Socket socket = null;
    public SocketThread(Socket socket){
        this.socket = socket;
    }
    private InputStream inputStream = null;
    private ObjectInputStream objectInputStream = null;

    @Override
    public void run() {
        Object o = null;
        try {
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            o = objectInputStream.readObject();
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            close();
        }

    }

    private  void close(){
        try {
            if (objectInputStream != null) objectInputStream.close();
            if (inputStream != null) inputStream.close();
            if (socket != null)  socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
