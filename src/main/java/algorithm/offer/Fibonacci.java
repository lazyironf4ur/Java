package algorithm.offer;

import org.junit.Test;

/**
 * @author:Lazy1ron
 * @date:2019/9/8 5:59
 * <p>
 * 斐波那契数列: 要求输入一个整数n，请你输出斐波那契数列的第n项
 * 两种实现：
 * 1、递归
 * 2、迭代
 */
public class Fibonacci {

    // 递归实现
    int fib_Recursive(int n) {
        if (n == 2 | n == 1) {
            return 1;
        }
        return fib_Recursive(n - 1) + fib_Recursive(n - 2);
    }

    // 迭代实现
    int fib_Iteration(int n) {
        if (n == 2 | n == 1) {
            return 1;
        }
        int first = 1, second = 1, third = 2;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 已知斐波那契数列值n，输出n所在的位置m
     */


    @Test
    public void recur_test() {
        System.out.println(new Fibonacci().fib_Recursive(40));
    }

    @Test
    public void iter_test() {
        System.out.println(new Fibonacci().fib_Iteration(40));
    }
}
