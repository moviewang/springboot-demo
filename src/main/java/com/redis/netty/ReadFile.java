package com.redis.netty;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.*;

/**
 * @Author: movie
 * @Date: 2018/5/28 15:45
 */
public class ReadFile {
    private Object data;

    public void read(ReadCallBack readCallBack) {
        try {
            readCallBack.onDate(this.data);
        } catch (Exception e) {
            readCallBack.onError(e);
        }
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ReadFile readFile = new ReadFile();
        readFile.read(new ReadCallBack() {
            @Override
            public void onDate(Object data) {
                try {
                    Thread.sleep(1l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(data);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("err:" +  t);
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable task1 = () -> {
            System.out.println("this is task1");
        };

        Callable task2 = () -> {
            Thread.sleep(5000L);
            return 111;
        };

        Future<?> f1 = executorService.submit(task1);
        Future<Integer> f2 = executorService.submit(task2);
        System.out.println("task1 is done ?" +  f1.isDone());
        System.out.println("task2 is done ?" +  f2.isDone());
        while (f1.isDone() && f2.isDone()) {
            break;
        }
        System.out.println(f2.get());
        executorService.shutdown();
        Long ss = -62135596800L;
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(ss), ZoneId.systemDefault()));
    }
}
