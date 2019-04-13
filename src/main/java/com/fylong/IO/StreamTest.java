package com.fylong.IO;

import java.io.*;

/**
 * Created by Fang on 2019/4/13.
 */
public class StreamTest {

    public void wirteByteToFile(){

        String hello = "文件读写";
        try {
            hello = new String(hello.getBytes("utf-8"),"gbk");
            System.out.println("gbk:"+hello);
//            hello = new String(hello.getBytes("gbk"),"utf-8");
//            System.out.println("utf-8:"+hello);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] byteArray = hello.getBytes();
        File file = new File("F:/test.txt");
        OutputStream os =null;
        try {
            os = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            os.write(byteArray);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void readByteFromFile(){
        File file = new File("F:/test.txt");
        byte[] byteArray = new byte[(int)file.length()];
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            int size = is.read(byteArray);
            String gbk = new String(byteArray,"utf-8");
            System.out.println("gbk:"+gbk);
            System.out.println("file size:"+size+"\ncontent:"+new String(gbk.getBytes("gbk"),"utf-8"));
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        StreamTest test = new StreamTest();
        test.wirteByteToFile();
        test.readByteFromFile();


        String s1= "你好啊的";
        String gbk = new String(s1.getBytes("utf-8"), "gbk");
        System.out.println(gbk);//浣犲ソ鍟婄殑
        String utf8 = new String(gbk.getBytes("gbk"), "utf-8");
        System.out.println(utf8);

        //1）老马，本来的编码格式是GB18030，编码(十六进制)是 C0CF C2ED。
        //2）这个二进制形式被错误当成了Windows-1252编码，解读成了字符“ÀÏÂí”。
        //3）随后这个字符进行了编码转换，转换成了UTF-8编码，形式还是“ÀÏÂí”，
        //但二进制变成了C380C38F C382C3AD，每个字符两个字节。
        //4）这个时候再按照GB18030解析，字符就变成了乱码形式“脌脧脗铆”，
        //而且这时无论怎么切换查看编码的方式，这个二进制看起来都是乱码。
        //知道乱码原本的格式，以及错误编码格式，以错误编码格式获取字节，再以正确编码格式编码获取原本字符。
        String str = "ÀÏÂí";
        String newStr = new String(str.getBytes("windows-1252"), "GB18030");
        System.out.println(newStr);
    }
}
