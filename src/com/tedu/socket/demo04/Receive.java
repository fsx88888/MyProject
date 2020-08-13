package com.tedu.socket.demo04;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.channels.DatagramChannel;
//UDP
public class Receive {
    public static void main(String[] args) {
        byte[] bytes = new byte[64];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        DatagramSocket datagramSocket = null;

        try {
            datagramSocket  = new DatagramSocket(9190);
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            String string = new String(data,0,data.length);
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }
        
}
