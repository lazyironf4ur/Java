package test;

/**
 * @author:Lazy1ron
 * @date:2019/10/17 14:58
 */
public class TestVolatile {
    int a = 1;
    int b = 2;

    public void change() throws InterruptedException{
        a = 3;
        Thread.sleep(10);   // 人肉加长这个赋值的时间
        b = a;
    }

    public void print(){
        System.out.println("b="+b+";a="+a);
    }

    public static void main(String[] args) {
        while (true){
            final TestVolatile test = new TestVolatile();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                        test.change();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();

        }
    }
}
