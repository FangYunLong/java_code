package com.fylong.io;

import java.io.*;

/**
 * 文件读写+
 * Created by Fang on 2019/4/13.
 */
public class StreamTest {


    public void writeByteToFile() throws IOException{
        String write = "write";
        byte[] byteArray = write.getBytes();
        File file = new File("F:\\Java\\temp.txt");
        //因为是用字节流来写媒介，所以对应的是OutputStream
        //又因为媒介对象是文件，所以用到子类是FileOutputStream
        OutputStream os = new FileOutputStream(file);
        os.write(byteArray);//写进去  byteArray -->os-->file
        os.close();
    }

    public void readByteFromFile() throws IOException{
        File file = new File("F:\\Java\\temp.txt");
        byte[] byteArray = new byte[(int)file.length()];
        //同上
        InputStream is = new FileInputStream(file);
        int size = is.read(byteArray);//读出去 file-->is-->byteArray
        System.out.println("size:"+size+"  content:"+new String(byteArray));
        is.close();
    }

    public static void main(String[] args) {
        StreamTest test = new StreamTest();
        try {
            test.writeByteToFile();
            test.readByteFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
