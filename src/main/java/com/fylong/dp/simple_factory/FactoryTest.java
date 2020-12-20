package com.fylong.dp.simple_factory;

import java.util.Scanner;

/**
 * 实现简单计算器
 * 简单工厂模式
 * Created by Fang on 2019/7/27.
 */
public class FactoryTest {

    public static void main(String[] args) {
        Operation oper = null;
        String mOperate = "";
        double mNum1 = 0;
        double mNum2 = 0;

        System.out.println("请输入数字A(回车结束):");
        Scanner sc = new Scanner(System.in);
        mNum1 = sc.nextDouble();
        System.out.println("请选择运算类型(+、-、*、/):");
        mOperate = sc.next();
        System.out.println("请输入数字B(回车结束):");
        mNum2 = sc.nextDouble();

        oper = SimpleFactory.CreateFactory(mOperate);
        oper.setNumber1(mNum1);
        oper.setNumber2(mNum2);

        System.out.println("计算结果："+oper.getResult());

    }

}
