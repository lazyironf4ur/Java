package algorithm.leetcode.high;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 我们有一组包含1和0的网格；其中1表示砖块。 当且仅当一块砖直接连接到网格的顶部，或者它至少有一块相邻（4 个方向之一）砖块不会掉落时，它才不会落下。
 *
 * 我们会依次消除一些砖块。每当我们消除 (i, j) 位置时， 对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这个消除而落下。
 *
 * 返回一个数组表示每次消除操作对应落下的砖块数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bricks-falling-when-hit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:Lazy1ron
 * @date:2019/11/23 9:38
 */
public class BricksFallingWhenHit {

    public static int[] hitbricks(int[][] grid, int[][] hits) {
        List<Block> hitsList = new ArrayList<>();
        int[] result = new int[]{};
        for (int i = 0; i < hits.length; i++) {
            int row = hits[i][0];
            int column = hits[i][1];
            hitsList.add(new Block(row, column));
        }
        for (Block b: hitsList) {
            if (grid[b.row][b.column]  == 1) {

            }
        }
        return result;
    }

    static class Block {
        public int row;
        public int column;

        public Block(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args) {
        int [][] a = new int[][]{{1,0,0,0},{1,1,1,0}};
        int[] row = a[0];
        System.out.println(Arrays.toString(row));
    }
}
