package com.fylong.DP.decorator;

/**
 * 具体装饰者
 * Created by Fang on 2019/7/28.
 */
public class Milk extends Decorator{
    private String name = "牛奶";

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String add(){
        return beverage.add()+ "\n添加了:"+ name;
    }

    @Override
    public double cost(){
        return beverage.cost()+5;
    }
}
