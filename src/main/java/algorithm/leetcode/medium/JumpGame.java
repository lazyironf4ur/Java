package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * https://leetcode-cn.com/problems/jump-game/
 *
 * @author:Lazy1ron
 * @date:2019/11/26 13:15
 */
public class JumpGame {

    // 首次成功提交：执行用时98 ms在所有 java 提交中击败了29.03%的用户。。。。内存消耗 :39.7 MB在所有 java 提交中击败了92.43%的用户

    // 这里采用贪心算法，运用递归倒序查找
    public static boolean canJump(int[] nums) {
        boolean flag2 = false;
        int count = 0;
        int len = nums.length;
        for (int i = len - 2; i > -1; i--) {    // 从数组的倒数第二个数向前查找第一个满足条件的数据位置
            if (nums[i] >= len - i - 1) {
                flag2 = true;
                count = i;
                break;
            }
        }

        if (count == 0 && flag2) return true;   // 判断是否是数组起始位置
        if (count >= 1) {   // 如不是起始位置，则判定[count -> n]成立，则将数组剩余部分分离出来做迭代
            boolean result = canJump(Arrays.copyOfRange(nums, 0, count + 1)) & flag2;
            return result;
        }
        return false;

    }

    public static void main(String[] args) {
        //int[] nums = new int[]{1,5,8,9,10,12,16,18};
        //System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 5)));
        //int[] nums = new int[]{2,3,1,1,4};
        //int[] nums = new int[]{3, 2, 1, 0, 4};
        int[] nums = new int[]{1,2,3};

        System.out.println(canJump(nums));
    }
}
