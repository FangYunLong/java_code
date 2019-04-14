package com.fylong.IO;

import java.io.*;

/**
 * 文件读写
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
    }
}
