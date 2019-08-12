package com.fylong.dp.strategy;

/**
 * 打折收费
 * Created by Fang on 2019/7/27.
 */
public class RebateRece implements CashRece {

    private double rebate;

    public RebateRece(double rebate){
        this.rebate = rebate;
    }

    @Override
    public double ReceCash(double mMoney) {
        return rebate*mMoney;
    }
}
