package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Movie on 2018/1/25.
 */
public class MultThread {

    public static void main(String[] args) {
//        single();
//        fixThread();
//        cacheThread();
        scheduleThread();
    }




    /**
     * 始终只有一个线程在执行， 线程出异常另一个线程替代他。
     * 类似一个学校的校长
     */
    public static void single() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int index = i;
            singleThreadExecutor.execute(() -> {
                try {
                    System.out.println(index  + "\tthread name:" + Thread.currentThread().getName());
                    if (index == 5) {
                        int a = 1 / 0;
                    }
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }


    /**
     * corePoolSize 和 maxmumPoolSize 大小一样
     */
    public static void fixThread() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int index = i;
            fixedThreadPool.execute(()->{
                System.out.println(index  + "\tthread name:" + Thread.currentThread().getName());
                if (index == 5) {
                    int a = 1 / 0;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 相当于new thread 每个任务一个线程,区别在与上一个任务在60l秒内完成，则会服用此线程，
     * 否则，新建一个线程
     */
    public static void cacheThread() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int index = i;

            try {
                Thread.sleep(70000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(() -> {
                System.out.println(index  + "\tthread name:" + Thread.currentThread().getName());
            });
        }
    }

    /**
     * 定时周期性threadpool
     */
    public static void scheduleThread() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(() -> {
            System.out.println("delay 3s");
        }, 3, TimeUnit.SECONDS);

        ScheduledExecutorService scheduleFixrate = Executors.newScheduledThreadPool(2);
        scheduleFixrate.scheduleAtFixedRate(() -> {
            System.out.println("3s");
        }, 1, 3, TimeUnit.SECONDS);
    }
}
