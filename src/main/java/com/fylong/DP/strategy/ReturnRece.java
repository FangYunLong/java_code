package com.fylong.DP.strategy;

/**
 * 返利收费
 * 300-100
 * Created by Fang on 2019/7/27.
 */
public class ReturnRece implements CashRece{

    private double moneyCondition;
    private double moneyRetuen;

    public ReturnRece(double moneyCondition,double moneyRetuen){
        this.moneyCondition = moneyCondition;
        this.moneyRetuen = moneyRetuen;
    }

    @Override
    public double ReceCash(double mMoney) {

        if (mMoney>=moneyCondition){
            mMoney = mMoney - Math.floor(mMoney/moneyCondition)* moneyRetuen;
        }
        return mMoney;
    }
}
