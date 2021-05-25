package algorithm.alibaba;

/**
 * @program: javatest
 * @description: 已知sqrt(2)约等于1.414，要求不用数学库，输出小数点后10位的数
 * @author: Lazy1ron
 * @create: 2021-05-25 05:00
 **/

public class SqrtFound {

    public static void func() {
        double start = 1.4;
        double end = 1.415;
        double sum = start*end;
        int num = 4;
        while (new Double(2.0000000000) - start*start >= 0.0000000001 && num < 11) {
            start = (end - start)/2 + start;
            num++;
            sum = start*start;
            while (sum >= 2 && num < 11) {
               start = start - (end - start)/2;
               num++;
               sum = start*start;
            }
        }

        System.out.println(start);
    }

    public static void main(String[] args) {
        func();
    }
}
