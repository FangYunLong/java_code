package com.fylong.dp.decorator;

/**
 * 抽象接口
 * 饮料接口
 * 定义装饰规范
 * Created by Fang on 2019/7/28.
 */
public interface Beverage {

    String name = "unknow";

    String add();

    double cost();
}
