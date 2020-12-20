package com.fylong.dp.strategy;

/**
 * 正常收费
 * Created by Fang on 2019/7/27.
 */
public class NormalRece implements CashRece {
    @Override
    public double ReceCash(double mMoney) {
        return mMoney;
    }
}
