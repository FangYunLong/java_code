package com.fylong.dp.strategy;

/**
 * 收费接口
 * 收费方式是多变的，独立出来。
 * 针对接口编程
 * Created by Fang on 2019/7/27.
 */
public interface CashRece {

    double ReceCash(double mMoney);

}
