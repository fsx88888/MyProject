package com.tedu.io;

import java.io.File;

public class Demo02 {
public static void test(File file){
    String[] list = file.list((dir, name) -> new File(name).isDirectory());
    for (String str : list){
        System.out.println(str);

    }
}
    public static void main(String[] args) {
        File file = new File("G:/MyProject");
        test(file);
    }
}
