package algorithm.leetcode.medium;

/**
 * 我们有两个长度相等且不为空的整型数组 A 和 B 。
 *
 * 我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。
 *
 * 在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。
 *
 * 给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:Lazy1ron
 * @date:2019/11/23 12:48
 */
public class MinimumSwapsToMakeSequencesIncreasing {
    public static int minSwap(int[] A, int[] B) {
        // 动态规划，cost[0]代表当前位不换时最小交换次数
        //          cost[1]代表当前位交换时最小交换次数
        int[] cost = new int[]{0, 1};
        for (int i = 1; i < A.length; i++) {
            // 如果两个数组的当前位都大于上一位，理论上不换就可以保持两个数组单调递增
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                // 如果满足这个条件，当前位交不交换都满足单调递增
                if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                    // 既然当前位不换，那么当前位的最小交换次数继承上一位的交换或不交换的最小值
                    cost[0] = Math.min(cost[0], cost[1]);
                    // 既然要交换，则是上一位交换或不交换的最小值加1
                    cost[1] = Math.min(cost[0], cost[1]) + 1;
                }
                // 如果交换当前位，就会导致不递增
                else {
                    // 如果要交换当前位，需要先交换上一位
                    cost[1] += 1;
                }
            }
            // 必须换
            else {
                int t = cost[0];
                // 如果不交换自己，那么需要交换上一位，所以继承上一位交换的次数
                cost[0] = cost[1];
                // 如果交换自己，那么上一位不交换，所以继承上一位不交换的次数并加1
                cost[1] = t + 1;
            }
        }
        return Math.min(cost[0], cost[1]);
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 8, 9, 10};
        int[] b = {0, 5, 5, 8, 9};
        System.out.println(minSwap(a, b));
    }
}
