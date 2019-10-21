package thread;


/**
 * @author:Lazy1ron
 * @date:2019/9/1 11:34
 */
public class RunThread {

    private static Integer model = 1000;

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println(Thread.currentThread().getName());
        // 创建Thread实例并传入一个Runnable对象 重写其run方法
        // 1.lamba表达式
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            synchronized (RunThread.class) {
                model = model+1;
                try {
                    RunThread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("model1: " + model);
            }

            int i = 100;
            int u = 200;
            int sum = i + u;
            System.out.println("sum1: " + sum);


        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                synchronized (RunThread.class) {
                    model = model+1;
                    System.out.println("model2: " + model);
                    RunThread.class.notify();
                }
                int i = 200;
                int u = 300;
                int sum = i + u;
                System.out.println("sum2: " + sum);

            }
        });
        thread1.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        myThread.start();

    }
    // 继承Thread类并重写run方法
    protected static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
