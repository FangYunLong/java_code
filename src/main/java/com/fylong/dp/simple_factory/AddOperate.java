package com.fylong.dp.simple_factory;

/**
 * 具体运算类
 * Created by Fang on 2019/7/27.
 */
public class AddOperate extends Operation{

    @Override
    public double getResult(){
        double result = 0;
        return getNumber1()+getNumber2();
    }

}
