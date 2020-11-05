package com.fylong.DP.factory;

/**
 * Created by Fang on 2019/8/9.
 */
public class FactoryTest {

    public static void main(String[] args) {

        IFactory ungergraduateFactory = new UndergraduateFactory();
        LeiFeng undergraduate = ungergraduateFactory.CreateLeiFeng();
        undergraduate.Sweep();

    }

}
