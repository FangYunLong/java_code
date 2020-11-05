package com.fylong.DP.strategy;

/**
 * 策略模式：定义一系列算法，从概念看都是完成相同工作（收钱）
 * 只是实现不一样（收钱方式）
 * 超市付费方式
 * Created by Fang on 2019/7/27.
 */
public class StrategyTest {

    public static void main(String[] args) {

        System.out.println("数量：10，单价：80，收费方式：正常收费");
        double price1 = new ReceContext("正常收费").getResult(80d);
        System.out.println("应收："+price1*10);

        System.out.println("数量：10，单价：80，收费方式：打折收费（八折）");
        double price2 = new ReceContext("打折收费").getResult(80d);
        System.out.println("应收："+price2*10);

        System.out.println("数量：10，单价：80，收费方式：返利收费（满三百返一百）");
        double price3 = new ReceContext("返利收费").getResult(500d);
        System.out.println("应收："+price3*10);

    }

}
