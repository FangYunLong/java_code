package com.fylong.DP.decorator;

/**
 * Created by Fang on 2019/7/28.
 */
public class Mocha extends Decorator{
    private String name = "摩卡";

    public Mocha(Beverage beverage) {
        this.beverage=beverage;
    }

    @Override
    public String add(){
        return beverage.add() + "\n添加了:" + name;
    }
    @Override
    public double cost(){
        return beverage.cost()+10;
    }
}
