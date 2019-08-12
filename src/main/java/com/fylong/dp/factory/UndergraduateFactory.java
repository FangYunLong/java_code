package com.fylong.dp.factory;

/**
 * 具体工厂类
 * Created by Fang on 2019/8/9.
 */
public class UndergraduateFactory implements IFactory{


    @Override
    public LeiFeng CreateLeiFeng() {
        return new Undergraduate();
    }
}
