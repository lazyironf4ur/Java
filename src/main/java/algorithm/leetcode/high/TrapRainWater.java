package algorithm.leetcode.high;

import java.util.PriorityQueue;

/**
 * @author:Lazy1ron
 * @date:2020/7/1 11:13
 */
public class TrapRainWater {

    private static TrapRainWater TRW = new TrapRainWater();

    //public int trapRainWater(int[][] matrix) {
    //    if (matrix.length<1 || matrix[0].length<1) {
    //        return 0;
    //    }
    //    // 先将矩阵中每个非边界的点与之相邻的上下左右各点的高度差记录到新的数组中
    //    // 1.边界中不存在的点记为null
    //    Integer[][] record = new Integer[(matrix.length-1)*(matrix[0].length-1)][4];
    //    for (int i = 1; i < matrix.length-1; i++) {
    //        for (int j = 1; j < matrix[0].length-1; j++) {
    //            for (int k = 0; k < 4; k++) {
    //                switch (k) {
    //                    case 0:     // 上
    //                        record[(j-1)+matrix.length*(i-1)][k] = matrix[i][j] - matrix[i-1][j];
    //                        break;
    //                    case 1:     //下
    //                        record[(j-1)+matrix.length*(i-1)][k] = matrix[i][j] - matrix[i+1][j];
    //                        break;
    //                    case 2:     //左
    //                        record[(j-1)+matrix.length*(i-1)][k] = matrix[i][j] - matrix[i][j-1];
    //                        break;
    //                    case 3:     //右
    //                        record[(j-1)+matrix.length*(i-1)][k] = matrix[i][j] - matrix[i-1][j+1];
    //                        break;
    //                }
    //            }
    //        }
    //    }
    //    System.out.println("111");
    //    return 0;
    //}

    public static void main(String[] args) {
        int[][] test = {{1,4,3,1,3,2},{3,2,1,3,2,4}, {2,3,3,2,3,1}};
    }

    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int m = heights[0].length;
        // 用一个vis数组来标记这个位置有没有被访问过
        boolean[][] vis = new boolean[n][m];
        // 优先队列中存放三元组 [x,y,h] 坐标和高度
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        // 先把最外一圈放进去
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.offer(new int[]{i, j, heights[i][j]});
                    vis[i][j] = true;
                }
            }
        }
        int res = 0;
        // 方向数组，把dx和dy压缩成一维来做
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            // 看一下周围四个方向，没访问过的话能不能往里灌水
            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dirs[k];
                int ny = poll[1] + dirs[k + 1];
                // 如果位置合法且没访问过
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                    // 如果外围这一圈中最小的比当前这个还高，那就说明能往里面灌水啊
                    if (poll[2] > heights[nx][ny]) {
                        res += poll[2] - heights[nx][ny];
                    }
                    // 如果灌水高度得是你灌水后的高度了，如果没灌水也要取高的
                    pq.offer(new int[]{nx, ny, Math.max(heights[nx][ny], poll[2])});
                    vis[nx][ny] = true;
                }
            }
        }
        return res;
    }

}
