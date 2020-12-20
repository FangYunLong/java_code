package com.fylong.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannleTest {

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();

        FileInputStream fis = new FileInputStream("/Users/yunlongfang/IdeaProjects/source/Redis.mmap");
        FileOutputStream fos = new FileOutputStream("/Users/yunlongfang/IdeaProjects/source/1.mmap");

        FileChannel inChannle = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (inChannle.read(buffer) != -1) {
            buffer.flip();

            outChannel.write(buffer);
            buffer.clear();
        }

        fis.close();
        fos.close();
        inChannle.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("cost:"+(end-start)+"ms");
    }


    @Test
    public void testDirect() throws Exception {
        long start = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("/Users/yunlongfang/IdeaProjects/source/Redis.mmap"),
                StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("/Users/yunlongfang/IdeaProjects/source/2.mmap"),
                StandardOpenOption.READ,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMap = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMap = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] bytes = new byte[inMap.limit()];
        inMap.get(bytes);
        outMap.put(bytes);

        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("direct cost:"+(end-start)+"ms");
    }


    @Test
    public void chanelTransfer() throws Exception {
        long start = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("/Users/yunlongfang/IdeaProjects/source/Redis.mmap"),
                StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("/Users/yunlongfang/IdeaProjects/source/3.mmap"),
                StandardOpenOption.READ,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);

        inChannel.transferTo(0,inChannel.size(),outChannel);

        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("chanelTransfer cost:"+(end-start)+"ms");
    }

}
