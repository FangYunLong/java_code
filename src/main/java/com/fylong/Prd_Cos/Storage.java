package com.fylong.Prd_Cos;


/**
 * 生产者--消费者
 * Created by Fang on 2019/4/13.
 */
public class Storage {

    //仓库最大存储量
    private final int MAX_SIZE = 100;

    //库存
    private int storage;

    private Storage(int storage){
        this.storage = storage;
    }

    public synchronized void Producer(String producer,int number){
        while(storage+number>MAX_SIZE) {
            System.out.println("由于生产者："+producer+"需生产数量："+number+",库存加生产数："+(number+storage)+"大于最大库存："+MAX_SIZE+"，所以暂不进行生产。");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        storage+=number;
        System.out.println("生产者："+producer+"生产了"+number+"个产品\t现仓储量为:" + storage);
        notifyAll();
    }

    public synchronized void Consumer(String consumer,int number){
        while(storage-number<0){
            System.out.println("由于消费者："+consumer+"需消费数量："+number+",大于库存："+storage+",所以暂不进行消费。");
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        storage-=number;
        System.out.println("消费者："+consumer+"消费了"+number+"个产品\t现仓储量为:" + storage);
        notifyAll();
    }

    public static void main(String[] args) {
        Storage storage = new Storage(0);

        Producer prd1 = new Producer("prd1",storage,20);
        Producer prd2 = new Producer("prd2",storage,50);
        Producer prd3 = new Producer("prd3",storage,90);

        Consumer cos1 = new Consumer("cos1",storage,90);
        Consumer cos2 = new Consumer("cos2",storage,10);
        Consumer cos3 = new Consumer("cos3",storage,70);

        prd1.start();
        prd2.start();
        prd3.start();

        cos1.start();
        cos2.start();
        cos3.start();

    }
}
