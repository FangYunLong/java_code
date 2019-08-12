package com.fylong.dp.simple_factory;

/**
 * Created by Fang on 2019/7/27.
 */
public class DivOperate extends Operation{

    @Override
    public double getResult(){
        double result = 0;
        if (getNumber2()==0){
            System.out.println("除数不能为零!");
        }else {
            result = getNumber1()/getNumber2();
        }
        return result;
    }

}
