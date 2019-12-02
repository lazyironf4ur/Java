package algorithm.leetcode.high;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * a[i][j] 代表第i个数组的第j个元素
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * TODO: 未解决
 * @author:Lazy1ron
 * @date:2019/12/2 16:13
 */
public class MergekSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int len = lists.length;
        // grid[第k个链表][链表中第n个节点的val]
        ListNode[][] grid = new ListNode[len][10000];

        for (int a = 0; a < len; a++) {
            // 每一条链表的头结点
            ListNode startNode = lists[a];
            if (null != startNode) {
                while (true) {
                    grid[a][startNode.val + 5000] = startNode;
                    if (null != startNode.next) {
                        startNode = startNode.next;
                    } else break;
                }
            }

        }
        ListNode result;

        // 初始化一个动态节点
        ListNode[] listNodes = new ListNode[10000];

        int index = 0;
        // 纵向遍历
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < len; j++) {

                if (null != grid[j][i]) {
                    ListNode dangqian = grid[j][i];
                    listNodes[index] = dangqian;
                    index++;
                }
            }
        }
        for (int z = 0; z <= index - 1; z++) {
            if (null != listNodes[z + 1]) {
                listNodes[z].next = listNodes[z + 1];
            }
        }


        return listNodes[0];
    }

    public ListNode mergeKLists2(ListNode[] lists) {

        int len = lists.length;
        for (int i = 0; i < len; i++) {
            List<ListNode> nodes = new ArrayList<>();
            while (null != lists[i]) {
                nodes.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }


        return null;
    }

    public static void main(String[] args) {


    }
}