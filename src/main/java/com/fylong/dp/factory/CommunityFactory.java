package com.fylong.dp.factory;

/**
 * Created by Fang on 2019/8/9.
 */
public class CommunityFactory implements IFactory{
    @Override
    public LeiFeng CreateLeiFeng() {
        return new Community();
    }
}
