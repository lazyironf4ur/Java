package algorithm.tecent;

import org.junit.Assert;

/**
 * 小Q定义了一种数列称为翻转数列:
 * 给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。
 * 例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.
 * 而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.
 * 小Q现在希望你能帮他算算前n项和为多少。
 * @author:Lazy1ron
 * @date:2019/11/25 10:31
 */
public class Total {

    public static int sum(int n, int m) {
        int result;
        if (n%2*m != 0) throw new IllegalArgumentException("bad argument!");
        return result = n*m/2;
    }

    public static void main(String[] args) {
        System.out.println("result: " + sum(16, 2));
    }
}
