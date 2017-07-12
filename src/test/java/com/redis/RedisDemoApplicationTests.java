package com.redis;

import com.redis.async.Task;
import com.redis.bean.User;
import com.redis.config.RedisProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate <String, User> redisTemplate;
	@Autowired
	private RedisProperties redisProperties;
	@Autowired
	private Task task;

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

//	@Test
//	public void propertiesTest() {
//		Assert.assertEquals(1, redisProperties.getMax().intValue());
//	}

//	@Test
//	public void propertiesRandomTest() {
//		Assert.assertNotEquals(0, redisProperties.getNum().intValue());
//	}
	@Test
	public void  testTask() {
		try {
			long start = System.currentTimeMillis();
			Future<String> taskOne = task.doTaskOne();
			Future<String> taskTwo = task.doTaskTwo();
			Future<String> taskThree = task.doTaskThree();

			while (true) {
				if (taskOne.isDone() && taskTwo.isDone() && taskThree.isDone()) {
					break;
				}
				Thread.sleep(1000);
			}
			long end = System.currentTimeMillis();
			System.out.println("all tasks have finished, time:" + (end - start));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
