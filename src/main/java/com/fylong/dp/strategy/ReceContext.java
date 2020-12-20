package com.fylong.dp.strategy;

/**
 * 上下文，封装收费方式
 * 在相应场景选择相应收费方式
 * 减少各类算法和调用算法的耦合
 * 策略模式和简单工厂结合
 * Created by Fang on 2019/7/27.
 */
public class ReceContext {
    CashRece rece;

    public ReceContext(String mType){

        switch (mType){
            case "正常收费" :
                rece = new NormalRece();
                break;
            case "打折收费" :
                rece = new RebateRece(0.8);
                break;
            case "返利收费" :
                rece = new ReturnRece(300,100);
                break;
        }

    }

    public double getResult(Double mMoney){
        return rece.ReceCash(mMoney);
    }
}
