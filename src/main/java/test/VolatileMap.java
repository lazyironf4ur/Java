package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author:Lazy1ron
 * @date:2019/10/20 8:37
 */
public class VolatileMap {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
    private static volatile Integer num = 0;
    private static Map<java.lang.Thread, String> map = new HashMap<>();
    private volatile String name;

    public static void main(String[] args) {
        Executor executor = new ThreadPoolExecutor(5,
                10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        while (num <= 9) {
            synchronized (num) {
                executor.execute(() -> {
                    map.put(Thread.currentThread(), Thread.currentThread().getName());
                    num++;
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                });
            }
        }

        map.entrySet().stream()
                .forEach(o -> {
                    System.out.println(o.getKey() + " : " + o.getValue());
                });
    }

}
