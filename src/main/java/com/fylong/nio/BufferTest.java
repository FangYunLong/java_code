package com.fylong.nio;


import org.junit.Test;

import java.nio.ByteBuffer;

/**
 *     position:位置，缓冲区正在操作数据的位置
 *     limit:界限，缓冲区中可操作数据的大小
 *     capacity:容量，缓冲区可储存最大数据的容量
 *     mark：标记，记录当前position的位置，reset()方法可以恢复到mark的位置
 *     0 <= mark <= position <= limit <= capacity
 *
 *     非直接缓冲区：通过allocate()方法在JVM内存中建立缓冲区
 *     直接缓冲区：通过allocateDirect()方法在物理内存中建立缓冲区
 */
public class BufferTest {

    @Test
    public void base(){

        String str = "12345";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("---allocate---");
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());

        buffer.put(str.getBytes());
        System.out.println("---put:"+str+"---");
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());

        //切换读数据模式
        buffer.flip();
        System.out.println("---flip---");
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());

        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println("---get:"+new String(bytes)+"---");
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());

        buffer.rewind();
        System.out.println("---rewind---");
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());

        //缓冲区位置被清空，但数据还在。
        buffer.clear();
        System.out.println("---clear---");
        System.out.println("position:"+buffer.position());
        System.out.println("limit:"+buffer.limit());
        System.out.println("capacity:"+buffer.capacity());
    }


}
