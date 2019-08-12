package com.fylong.dp.proxy;

/**
 * 请求类
 * Created by Fang on 2019/8/8.
 */
public class RealPursuit implements Pursuit{
    Girl girl;

    String name;

    public RealPursuit(String name,Girl girl){
        this.name = name;
        this.girl = girl;
    }

    @Override
    public String giveFlowers() {
        return name + " give flowers to " + girl.name;
    }

    @Override
    public String giveChocolate() {
        return name + " give Chocolate " + girl.name;
    }
}
