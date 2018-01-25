package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Movie on 2018/1/25.
 */
public class MultThread {

    public static void main(String[] args) {
//        single();
        fixThread();
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
}
