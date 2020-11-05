package com.fylong.Prd_Cos;


/**
 * Created by Fang on 2019/4/13.
 */
public class Producer extends Thread{
    private String producer;
    private Storage storage;
    private int number;

    public Producer(String producer,Storage storage,int number){
        this.producer = producer;
        this.storage = storage;
        this.number = number;
    }

    public void run(){
        storage.Producer(producer,number);
    }
}
