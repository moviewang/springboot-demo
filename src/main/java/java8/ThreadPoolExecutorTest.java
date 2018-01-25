package java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Movie on 2017/10/19.
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        /**
         * CachedThreadPool
         */
        /*ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(() -> {
                System.out.println(index);
                System.out.println(Thread.currentThread().getName());
            });
        }*/

        ExecutorService fixpool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixpool.execute(()->{
                System.out.println(index);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
