package volatileee;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

/**
 * @author:Lazy1ron
 * @date:2019/11/13 23:55
 */
public class VolatileTest {

    private static volatile int i = 0;
    private static volatile AtomicInteger integer = new AtomicInteger(0);

    private static CountDownLatch count = new CountDownLatch(5000);

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            integer.getAndIncrement();
            count.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 5000; j++) {
            new Thread(new MyTask()).start();
        }
        count.await();
        System.out.println(i);
        System.out.println(integer.toString());
    }

}
