package com.fylong.dp.factory;

/**
 * 抽象工厂接口
 * 工厂模式：克服简单工厂模式违背开放-封闭原则的缺点
 * 将一个类的实例化延迟到相应子类
 * Created by Fang on 2019/8/9.
 */
public interface IFactory {

    LeiFeng CreateLeiFeng();

}
