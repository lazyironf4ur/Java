package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author:Lazy1ron
 * @date:2019/9/2 21:30
 */
public class ListOp {
    private static final int CAPACITY = 10;
    private static List<String> arrayList = new ArrayList<>();
    private static List<String> linkedList = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < CAPACITY ; i++) {
                    arrayList.add(Integer.toString(i));
                }
                System.out.println("Thread name: " + Thread.currentThread().getName() + " list: " + arrayList);
            }
        }, "thread-1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < CAPACITY ; i++) {
                    linkedList.add(Integer.toString(i));
                }
                System.out.println("Thread name: " + Thread.currentThread().getName() + " list: " + linkedList);
            }
        }, "thread-2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("End");

    }

}
