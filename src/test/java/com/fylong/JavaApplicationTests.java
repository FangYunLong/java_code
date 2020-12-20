package com.fylong;

import com.fylong.web.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JavaApplicationTests {

	@Resource
	private RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {

		User user = User.builder().name("方").age("20").build();

		redisTemplate.opsForValue().set("user", user);

		log.info("user="+redisTemplate.opsForValue().get("user"));

	}

	@Test
	public void getUser(){

		ApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
		User user = context.getBean("user", User.class);

	}

}
