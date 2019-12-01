package algorithm.leetcode.medium;


import org.junit.Assert;

import java.util.Arrays;

/**
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * <p>
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/online-stock-span
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author:Lazy1ron
 * @date:2019/12/1 13:31
 */
public class StockSpanner {

    private Integer[] a = new Integer[15000];

    private int index = 0;

    public StockSpanner() {

    }

    public int next(int price) {
        int p = 1;
        a[index] = price;
        index++;
        if (index == 1) {
            return 1;
        }

        for (int i = index - 2; i > -1; i--) {
            if (a[i] <= a[index - 1]) p++;
            else break;
        }
        return p;
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        int[] test = new int[]{100, 80, 60, 70, 60, 75, 85};
        int[] result = new int[7];
        int[] expected = new int[]{1, 1, 1, 2, 1, 4, 6};
        for (int i = 0; i < test.length; i++) {
            result[i] = obj.next(test[i]);
        }

        Assert.assertEquals(true, Arrays.equals(expected, result));
    }
}
