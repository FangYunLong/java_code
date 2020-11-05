package com.fylong.DP.decorator;

/**
 * 被装饰者
 * 具体的对象
 * Created by Fang on 2019/7/28.
 */
public class Coffee implements Beverage{
    private String name = "咖啡";

    @Override
    public String add() {
        return name;
    }

    @Override
    public double cost() {
        return 30;
    }
}
