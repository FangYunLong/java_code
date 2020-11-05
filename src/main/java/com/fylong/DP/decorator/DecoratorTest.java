package com.fylong.DP.decorator;

/**
 * 装饰模式：为已有功能动态添加更多功能的一种方式！
 * 需要新的功能时，实现Decorator（装饰者）,实现自己具体的功能，
 * 传入原有功能（被装饰对象），添加新增功能（装饰对象）
 * Created by Fang on 2019/7/28.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        coffee = new Milk(coffee);
        coffee = new Mocha(coffee);
        System.out.println(coffee.add()+"\n一共花费"+coffee.cost()+"元");
    }




}
