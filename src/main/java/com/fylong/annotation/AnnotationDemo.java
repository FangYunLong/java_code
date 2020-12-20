package com.fylong.annotation;

import com.fylong.web.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

@Slf4j
public class AnnotationDemo {

    @Test
    public void testInvoke() throws Exception {

        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        User user = User.builder().name("test").build();
        log.info(user.toString());

        Field field = clazz.getDeclaredField("user");
        field.setAccessible(true);

        String name = field.getName();
        name = name.substring(0,1).toUpperCase()+name.substring(1,name.length());

        String setMethodName = "set" + name;
        Method method = clazz.getMethod(setMethodName, User.class);

        method.invoke(userController,user);
        log.info(userController.getUser().toString());

    }

    @Test
    public void testAnnotation(){

        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        Stream.of(clazz.getDeclaredFields()).forEach(field -> {

            AutoWired annotation = field.getAnnotation(AutoWired.class);

            if(annotation != null){
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {

                    User o = (User)type.newInstance();
                    o.setName("test");
                    field.set(userController,o);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        log.info(userController.getUser().toString());
    }

}
