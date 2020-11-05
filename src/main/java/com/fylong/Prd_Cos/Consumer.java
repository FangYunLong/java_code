package com.fylong.Prd_Cos;

/**
 * Created by Fang on 2019/4/13.
 */
public class Consumer extends Thread{
    private String consumer;
    private Storage storage;
    private int number;

    public Consumer(String consumer,Storage storage,int number){
        this.consumer = consumer;
        this.storage = storage;
        this.number = number;
    }

    public void run(){
        storage.Consumer(consumer,number);
    }
}
