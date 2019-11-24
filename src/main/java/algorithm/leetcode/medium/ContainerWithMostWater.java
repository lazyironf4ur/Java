package algorithm.leetcode.medium;

/**
 * @author:Lazy1ron
 * @date:2019/11/23 6:02
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainerWithMostWater {

    /**
     * @Description: 第一种简单暴力 时间复杂度 O(n^2)
     * @Param [height]
     * @return int
     **/

    public static int maxArea(int[] height) {
        int length = height.length;
        if(length<2) {
            throw new IllegalArgumentException("数组长度必须大于或等于2");
        }
        int area = 0;
        int[] col = new int[length];

        for(int i=0; i<length; i++) {
            for(int j=i+1; j<length; j++) {
                if(height[i] < height[j]) {
                    area = height[i] * (j-i);
                } else {
                    area = height[j] * (j-i);
                }
                if(col[j-i] < area) {
                    col[j-i] = area;
                }
            }
        }

        int max = col[0];
        for (int k=1; k<col.length; k++) {
            if(max < col[k]) {
                max = col[k];
            }
        }
        return max;
    }

    /**
     * 贪心算法
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int i = 0,j = height.length - 1;
        int area = 0, max = 0;
        while (i < j) {
            area = Math.min(height[i], height[j]) * (j-i);
            max = Math.max(max, area);
            if (height[i] > height[j]) j--;
            else i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7,9,10,6,5};
        //int[] array = {1};
        System.out.println("枚举比较(O(n^2)): " + maxArea(array));
        System.out.println("贪心算法(O(n)): " + maxArea2(array));
    }
}
