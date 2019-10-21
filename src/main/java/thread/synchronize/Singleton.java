package thread.synchronize;

/**
 * @author:Lazy1ron
 * @date:2019/9/5 15:31
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){}

    public static Singleton SingleInstance() {

        synchronized(Singleton.class) {
            if (singleton == null) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            Object object;
            object = Singleton.SingleInstance();
            System.out.println(object);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new MyThread().start();
        }
    }
}
