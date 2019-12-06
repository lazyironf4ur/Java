package algorithm.leetcode.medium;

/**
 * We are given the root node of a maximum tree: a tree where every node has a value greater than any other value in its subtree.
 * <p>
 * Just as in the previous problem, the given tree was constructed from an list A (root = Construct(A)) recursively with the following Construct(A) routine:
 * <p>
 * If A is empty, return null.
 * Otherwise, let A[i] be the largest element of A.  Create a root node with value A[i].
 * The left child of root will be Construct([A[0], A[1], ..., A[i-1]])
 * The right child of root will be Construct([A[i+1], A[i+2], ..., A[A.length - 1]])
 * Return root.
 * Note that we were not given A directly, only a root node root = Construct(A).
 * <p>
 * Suppose B is a copy of A with the value val appended to it.  It is guaranteed that B has unique values.
 * <p>
 * Return Construct(B).
 * <p>
 *     执行用时 :
 * 0 ms
 * , 在所有 java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗 :
 * 34.8 MB
 * , 在所有 java 提交中击败了
 * 81.03%
 * 的用户
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author:Lazy1ron
 * @date:2019/12/6 18:46
 */
public class MaximumBinaryTreeII {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (null == root) return null;

        if (val > root.val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            newRoot.right = null;
            return newRoot;
        } else if (val == root.val) {
            new Exception("No way");
        } else if (null != root.right) {
            TreeNode tmp = root.right;
            TreeNode newNode = new TreeNode(val);
            if (newNode.val > tmp.val) {
                root.right = newNode;
                newNode.left = tmp;
            }
            while (newNode.val < tmp.val) {
                if (null == tmp.right) {
                    tmp.right = newNode;
                    return root;
                } else if (newNode.val < tmp.right.val) {
                    tmp = tmp.right;
                    continue;
                } else if (newNode.val > tmp.right.val) {
                    TreeNode a = tmp.right;
                    tmp.right = newNode;
                    newNode.left = a;
                    return root;
                }
            }

        } else if (null == root.right) {
            root.right = new TreeNode(val);
            return root;
        }

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
