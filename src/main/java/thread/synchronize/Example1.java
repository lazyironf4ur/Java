package thread.synchronize;

/**
 * @author:Lazy1ron
 * @date:2019/12/5 22:05
 */
public class Example1 {

    private volatile Integer a1 = 0;

    private Integer a2 = 0;

    public synchronized void syncAdd1() {
        ++a1;
    }
    public synchronized void syncAdd2() {
        ++a2;
    }

    public void normalAdd1() {
        ++a1;
    }

    public void normalAdd2() {
        ++a2;
    }

    public static void main(String[] args) throws InterruptedException {
        Example1 example1 = new Example1();
        //example1.normalAdd();
        //example1.syncAdd();
        for (int i = 0; i < 100; i++) {
            System.out.println(i);

            new Thread(() -> {
                //example1.syncAdd1();
                example1.normalAdd2();
            }).start();
        }
        Thread.currentThread().join();
        //Thread.sleep(1000);
        System.out.println("操作结束");
        System.out.println(example1.a1);
        System.out.println(example1.a2);

    }
}
