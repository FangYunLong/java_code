package com.fylong.DP.simple_factory;

/**
 * 运算类
 * Created by Fang on 2019/7/27.
 */
public class Operation {
    private double Number1 = 0;
    private double Number2 = 0;

    public void setNumber1(double mNumber1) {
        this.Number1 = mNumber1;
    }

    public void setNumber2(double mNumber2) {
        this.Number2 = mNumber2;
    }

    public double getNumber1() {
        return Number1;
    }

    public double getNumber2() {
        return Number2;
    }

    public double getResult(){
        return 0;
    };
}
