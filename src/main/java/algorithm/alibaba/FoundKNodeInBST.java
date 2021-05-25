package algorithm.alibaba;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @program: javatest
 * @description: 找到二叉搜索树第K小的节点
 * @author: Lazy1ron
 * @create: 2021-05-25 05:30
 **/

public class FoundKNodeInBST {


    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int t;


        TreeNode(int t) {
            this.t = t;
        }

    }

    public static ArrayList<TreeNode> founditer(TreeNode root, ArrayList<TreeNode> nodeList) {
        if (root == null) return nodeList;

        founditer(root.left, nodeList);

        nodeList.add(root);

        founditer(root.right, nodeList);

        return nodeList;
    }

    public static int foundtigui(TreeNode root, int k) {
        LinkedList<TreeNode> nodeLinkedList = new LinkedList<>();

        while (true) {
            while (root != null) {
                nodeLinkedList.add(root);
                root = root.left;
            }
            root = nodeLinkedList.removeLast();
            if (--k == 0) return root.t;
            root = root.right;
        }
    }




    public static TreeNode buildBST(int[] vals) {
        TreeNode root = new TreeNode(vals[0]);
        TreeNode temp;
        for (int i = 1; i < vals.length; i++) {
            temp = root;
            while (temp != null) {
                if (vals[i] > temp.t) {
                    if (temp.right == null) {
                        temp.right = new TreeNode(vals[i]);
                        break;
                    } else temp = temp.right;
                }
                if (vals[i] < temp.t) {
                    if (temp.left == null) {
                        temp.left = new TreeNode(vals[i]);
                        break;
                    } else temp = temp.left;
                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        int k = 5;
        int[] vals = {5, 46, 82, 16, 18, 19, 3, 25};
        ArrayList<TreeNode> nodes = new ArrayList<>();
        founditer(buildBST(vals), nodes);
        System.out.println(nodes.get(k - 1).t);
        System.out.println(foundtigui(buildBST(vals), k));
    }
}
