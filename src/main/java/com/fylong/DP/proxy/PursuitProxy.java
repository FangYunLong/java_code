package com.fylong.DP.proxy;

/**
 * 代理类
 * Created by Fang on 2019/8/8.
 */
public class PursuitProxy implements Pursuit{
    Pursuit request;

    public PursuitProxy(Pursuit RealPursuit){
        request = RealPursuit;
    }

    @Override
    public String giveFlowers() {
        return request.giveFlowers();
    }

    @Override
    public String giveChocolate() {
        return request.giveChocolate();
    }
}
