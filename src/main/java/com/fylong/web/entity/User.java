package com.fylong.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.reflect.Constructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User implements Serializable {

    private String name;

    private String age;

    public void test() throws Exception {

        Class<User> u = User.class;
        Constructor<User> declaredConstructor = u.getDeclaredConstructor();
        User user = declaredConstructor.newInstance();

    }


}
