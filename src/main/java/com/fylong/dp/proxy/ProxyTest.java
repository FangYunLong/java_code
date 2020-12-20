package com.fylong.dp.proxy;

/**
 * Created by Fang on 2019/8/8.
 */
public class ProxyTest {

    public static void main(String[] args) {

        Girl xiaohong = new Girl("xiaohong");
        Pursuit xiaoming = new RealPursuit("xiaoming",xiaohong);
        Pursuit proxy = new PursuitProxy(xiaoming);
        System.out.println(proxy.giveChocolate());

    }

}
