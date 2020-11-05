package com.fylong;

import com.fylong.Web.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
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

}
