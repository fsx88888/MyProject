package com.tedu.socket.Demo05;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost();//获取本主机名 和ip地址
            System.out.println(host);

            InetAddress byName = InetAddress.getByName("www.163.com");//获取网络主机ip地址
            System.out.println(byName);



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
