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
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;
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
//	@Test
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

	@Test
	public void testRedis() {
		Set<ZSetOperations.TypedTuple<User>> set = new HashSet<>();
		User user = new User("zhangsan", 11);
		User user1 = new User("zhangsan1", 12);
		User user2 = new User("zhangsan2", 11);
		User user3 = new User("zhangsan3", 13);
		User user4 = new User("zhangsan4", 114);

		long start = System.currentTimeMillis();
        System.out.println("max:" + Long.MAX_VALUE);
        redisTemplate.opsForZSet().add("feed", user, 1);
		redisTemplate.opsForZSet().add("feed", user1, 3);
		redisTemplate.opsForZSet().add("feed", user2, 2);
		redisTemplate.opsForZSet().add("feed", user3, 6);
		redisTemplate.opsForZSet().add("feed", user4, 5);

		Long length = redisTemplate.opsForZSet().zCard("feed");
        Set<ZSetOperations.TypedTuple<User>> tupleSet = redisTemplate.opsForZSet().reverseRangeWithScores("feed", 0, -1);

        for (ZSetOperations.TypedTuple<User> userTypedTuple : tupleSet) {
            System.out.println(userTypedTuple.toString());
        }

        Double score = redisTemplate.opsForZSet().score("feed", user1);
        System.out.println("score" + score);
        System.out.println(length);



	}
}
