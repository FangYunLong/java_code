package com.fylong.string;

import java.io.UnsupportedEncodingException;

/**
 * 编码问题
 * Created by Fang on 2019/4/14.
 */
public class ByteToStringTest {

    /**
     * 恢复乱码
     * @param str 乱码字符串
     */
    public static void recover(String str) throws UnsupportedEncodingException {
        String[] charsets = new String[]{"utf-8","gbk","gb18030","windows-1252"};
        System.out.println("传入乱码:"+str);


        for (int i = 0;i < charsets.length;i++){
            for (int j = 0;j < charsets.length;j++){
                if (i!=j){
                    String recover = new String(str.getBytes(charsets[i]),charsets[j]);
                    System.out.println("recover:"+recover);
                    System.out.println("假设字符正确编码为"+charsets[j]+"\n错误使用"+charsets[i]+"编码");
                }
            }
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        //gbk-->utf-8
        String s1= "编码格式变换";
        String gbk = new String(s1.getBytes("utf-8"), "gbk");
        String utf8 = new String(gbk.getBytes("gbk"), "utf-8");
        System.out.println("gbk:" + gbk);
        System.out.println("utf-8:" + utf8);

        String hello = "写进去,读出去";
        System.out.println("encode-utf-8:"+ new String(hello.getBytes("utf-8")));
        System.out.println("encode-gbk:"+ new String(hello.getBytes("gbk")));
        System.out.println("code-gbk:"+new String(hello.getBytes("utf-8"),"gbk"));
        System.out.println("code-utf-8:"+new String(hello.getBytes("utf-8"),"utf-8"));

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

        ByteToStringTest.recover(str);
    }
}
