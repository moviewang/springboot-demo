package com.redis.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * Created by Movie on 2017/7/12.
 */
@Component
public class Task {
    private static Random random = new Random();

    @Async
    public Future<String> doTaskOne() throws InterruptedException {
        System.out.println("start task one");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("finish task one, time：" + (end -start) );
        return new AsyncResult<>("task one success");
    }

    @Async
    public Future<String> doTaskTwo() throws InterruptedException {
        System.out.println("start task two");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("finish task two, time：" + (end -start) );
        return new AsyncResult<>("task two success");
    }

    @Async
    public Future<String> doTaskThree() throws InterruptedException {
        System.out.println("start task three");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("finish task three, time：" + (end -start) );
        return new AsyncResult<>("task three success");
    }
}
