package com.fylong.dp.prototype;

import java.io.IOException;

/**
 * Created by Fang on 2019/8/12.
 */
public class PrototypeTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Resume name = new Resume("xiaoming");
        name.setWorkExperience("2年","蚂蚁金服");
        System.out.println(name.display());

        Resume name1 = name.deepClone();
        name1.setWorkExperience("3年","微软");
        System.out.println(name1.display());


    }
}
