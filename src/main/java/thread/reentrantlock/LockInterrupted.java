package thread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:Lazy1ron
 * @date:2019/9/5 15:50
 */
public class LockInterrupted extends Thread{

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    int lockNum;

    public LockInterrupted(int lockNum, String name) {
        this.lockNum = lockNum;
        super.setName(name);
    }

    @Override
    public void run() {
        if (lockNum == 0) {
            try {
                lock1.lockInterruptibly();
                sleep(5000);
                lock2.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock1.isHeldByCurrentThread()) lock1.unlock();
                if(lock2.isHeldByCurrentThread()) lock2.unlock();
            }
        } else {
            try {
                lock2.lockInterruptibly();
                sleep(5000);
                lock1.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(lock1.isHeldByCurrentThread()) lock1.unlock();
                if(lock2.isHeldByCurrentThread()) lock2.unlock();
            }
        }

        System.out.println(Thread.currentThread().getId() + ":线程退出");
    }

    public static void main(String[] args) {
        new LockInterrupted(2, "线程1").start();
        new LockInterrupted(1, "线程2").start();
    }
}
