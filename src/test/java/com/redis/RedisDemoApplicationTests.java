package com.redis;

import com.redis.bean.User;
import com.redis.config.RedisProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate <String, User> redisTemplate;
	@Autowired
	private RedisProperties redisProperties;

	@Test
	public void contextLoads() {
	}

//	@Test
//	public void stringRedisTest() {
//		stringRedisTemplate.opsForValue().set("hello", "springboot redis");
//		Assert.assertEquals("springboot redis", stringRedisTemplate.opsForValue().get("hello"));
//	}

//	@Test
//	public void redisTemplateTest() {
//		User user = new User();
//		user.setAge(22);
//		user.setUsername("movie");
//
//		redisTemplate.opsForValue().set(user.getUsername(), user);
//
//		Assert.assertEquals(22, redisTemplate.opsForValue().get("movie").getAge());
//	}

	@Test
	public void propertiesTest() {
		Assert.assertEquals(1, redisProperties.getMax().intValue());
	}

	@Test
	public void propertiesRandomTest() {
		Assert.assertNotEquals(0, redisProperties.getNum().intValue());
	}
}
