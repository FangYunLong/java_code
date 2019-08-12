package com.fylong.dp.decorator;

/**
 * 抽象装饰者
 * 将装饰者公共方法属性拎出来
 * Created by Fang on 2019/7/28.
 */
public class Decorator implements Beverage{
    Beverage beverage;

    @Override
    public String add() {
        return name;
    }

    @Override
    public double cost() {
        return 0;
    }
}
