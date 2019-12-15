package algorithm.leetcode.easy;

/**
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 *
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:Lazy1ron
 * @date:2019/12/14 11:33
 *
 * 不知道哪里错了，晕
 */
public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        int sum = 0;
        int a = 0;

        // 先排序，使差值大的排在前面，然后选距离小的城市并进行标记
        for (int j = len; j >= 1; j-- ) {
            for (int i = 1; i < j; i++) {
                int less1 = Math.abs((costs[i][0] - costs[i][1]));
                int less2 = Math.abs((costs[i-1][0]- costs[i-1][1]));
                if (less1 > less2) {
                    int[] tmp = costs[i];
                    costs[i] = costs[i-1];
                    costs[i-1] = tmp;
                }
            }
        }

        for (int x = 0; x < len; x++) {
            if (costs[x][0] >= costs[x][1] && a < len/2) {
                sum += costs[x][1];
                a++;
            } else {
                sum += costs[x][0];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] problem = {{10,20},{30,200},{400,50},{30,20}};
        int[][] problem2 = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};

        System.out.println(new TwoCityScheduling().twoCitySchedCost(problem2));
    }
}
