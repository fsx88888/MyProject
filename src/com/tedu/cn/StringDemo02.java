package com.tedu.cn;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringDemo02 {
    //spilt:特殊符号不适应： . | \ $ + * 如果要使用加\\
    public static void test01(){
        String str = "hel.lo-worl.d";
        String[] split = str.split("\\.");
        for (int i = 0; i < split.length; i++){
            System.out.println(split[i]);
        }
    }
    //StringTokenizer:  用以拆解字符串，不用管特殊字符
    public static void test02(){
        String str = "hel.lo-worl.d";
        StringTokenizer token = new StringTokenizer(str,".");
        while ( token.hasMoreElements()){
            String str2 = (String)token.nextElement();
            System.out.println(str2);
        }
    }
    //输入一个字符串，统计该字符串中单个字符串出现的次数
    public static int test03(String input,String word){
        String[] strs = input.split("");
        int count = 0;
        for (int i = 0; i < strs.length; i++){
            if(strs[i].equals(word))
                count++;
            System.out.println(strs[i]);
        }
        return  count;
    }
    //spilt 拆分，若匹配字符在字符串最后一位，则无法识别
    public static void test04(String input,String word){
        String[] strs = input.split(word);

        for (int i = 0; i < strs.length; i++){

            System.out.println("*"+strs[i]);
        }
    }
    //手写拆分字符串成数组并统计特殊字符的次数
    public static int test05(String word){
        String str = "helloworld";
        int count = 0;
        String[] strs = new String[str.length()];
        for (int i = 0; i < str.length(); i++){
             strs[i] = str.substring(i,i+1);
             if (strs[i] == word)
                 count ++;
        }
        System.out.println(Arrays.toString(strs));
        return count;
    }
    //判断一个字符串中某一个子字符串出现的次数
    public static  int test06(String input, String str){

        int position = input.indexOf(str);
        int count = 0;
        while(position != -1){
            count ++;
            input = input.substring(position +1);
            position = input.indexOf(str);
        }
        return count;
    }
    //StringBuffer 最大的升级是可以在原有的内存空间新增，无需开辟新的空间
    public static void test07(){
        StringBuffer sb = new StringBuffer("abc");
        sb.append("aaa");
        System.out.println(sb);
   }
   //"12345678"--->12,345,678
   public static String test08(String digital){
       StringBuffer sb = new StringBuffer(digital);
        for (int i = digital.length() - 3; i > 0; i -= 3){
            sb.insert(i,",");
        }
        return sb + "";
   }
    public static void main(String[] args) {
        //test01();
        //test02();
        //int numb = test03("helloworld", "l");
        //System.out.println(numb);
        //test04("oohelloworldoo", "o");
        //System.out.println(test05("l"));
        // System.out.println(test06("helloworld","o"));
        //test07();
         System.out.println(test08("12345678"));
    }
}
