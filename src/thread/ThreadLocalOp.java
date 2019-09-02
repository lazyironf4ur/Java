package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author:Lazy1ron
 * @date:2019/9/1 17:41
 */
public class ThreadLocalOp {

    public static void main(String[] args) throws InterruptedException {
        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
        for (int i = 0; i <= threads ; i++) {
            new Thread(() -> {
                for (int j = 0; j < 4 ; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");

                countDownLatch.countDown();
            }, "thread -" +  i).start();
        }
        countDownLatch.await();
        System.out.println("End!");
    }

    private static class InnerClass {
        public void add(String str) {
            StringBuilder stringBuilder = Counter.counter.get();
            Counter.counter.set(stringBuilder.append(str));
        }

        public void print() {
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%d, Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString()
                    );
        }

        public void set(String word) {
            Counter.counter.set(new StringBuilder(word));
            System.out.printf("Set Thread name:%s , ThreadLocal hashcode:%d, Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString()
            );
        }
    }

    private static class Counter {
        private static ThreadLocal<StringBuilder> counter = new ThreadLocal<StringBuilder>() {
            @Override
            protected StringBuilder initialValue() {
                return new StringBuilder();
            }
        };

    }

}
