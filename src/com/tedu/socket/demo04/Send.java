package com.tedu.socket.demo04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {
    public static void main(String[] args) {
        String msg = "helloReceive";
        DatagramPacket datagramPacket ;
        DatagramSocket datagramSocket = null;
        InetAddress ip =null;

        try {
             ip = InetAddress.getByName("127.0.0.1");
            datagramPacket = new DatagramPacket(msg.getBytes(), msg.length(),ip,9190);
            datagramSocket  = new DatagramSocket();
            datagramSocket.send(datagramPacket);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }

}
