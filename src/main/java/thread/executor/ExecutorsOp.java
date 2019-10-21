package thread.executor;

import java.util.concurrent.*;

/**
 * @author:Lazy1ron
 * @date:2019/9/5 20:30
 */
public class ExecutorsOp {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread name: " + Thread.currentThread().getName() + " Thread number arrived the Barrier: " + cyclicBarrier.getNumberWaiting());
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                    System.out.printf("Thread: %s Go on!\n", Thread.currentThread().getName());
                    countDownLatch.countDown();
                }
            };
            service.execute(runnable);

        }
        countDownLatch.await();
        System.out.println("exit");
        service.shutdown();
    }


}
