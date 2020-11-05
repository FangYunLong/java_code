package com.fylong.DP.simple_factory;

/**
 * 工厂类
 * Created by Fang on 2019/7/27.
 */
public class SimpleFactory {

    public static Operation CreateFactory(String operate){
        Operation oper = null;

        switch (operate){
            case "+" :
                oper = new AddOperate();
                break;
            case "/" :
                oper = new DivOperate();
                break;
        }

        return oper;
    }

}
