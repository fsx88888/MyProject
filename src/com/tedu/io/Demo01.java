package com.tedu.io;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) {
        //file 可以代表一个不存在的文件
       File file =  new File("abc.txt");
        try { file.createNewFile();

            System.out.println(file.getName());
            System.out.println("绝对路径: " + file.getAbsoluteFile());
            System.out.println("相对路径: " + file.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
