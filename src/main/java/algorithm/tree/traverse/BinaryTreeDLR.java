package algorithm.tree.traverse;

import java.util.*;



public class BinaryTreeDLR {

    class Node<T> {
        T t;
        Node<T> left;
        Node<T> right;


        public Node(T t) {
            this.t = t;
        }
    }


    public static void DLRiterator(Node tree) {
        //当前节点
        if (tree != null) {
            System.out.print(tree.t + " ");
            DLRiterator(tree.left);
            DLRiterator(tree.right);
        }
    }


    // 倒序遍历
    public static void DLRWithStack(Node tree) {
        Node temp = tree;
        if (temp == null) return;

        Stack stack = new Stack();
        stack.push(temp);
        while (temp != null) {
            if (temp.left == null) {
                if (temp.right == null) {
                    Node out = temp;
                    System.out.print(temp.t + " ");
                    stack.pop();
                    if (stack.empty()) {
                        break;
                    }
                    temp = (Node) stack.peek();
                    if (out.equals(temp.left)) {
                        temp.left = null;
                    } else {
                        temp.right = null;
                    }
                    continue;
                }
                temp = (Node) stack.push(temp.right);
                continue;
            }
            temp = (Node) stack.push(temp.left);
        }
    }

    public Node array2BinaryTree(Object[] o, int index) {
        Node root = null;
        if (index < o.length) {
            Object obj = o[index];
            if (obj == null) {
                return null;
            }
            index++;
            root = new Node(obj);

            root.left = array2BinaryTree(o, 2*index - 1);
            root.right = array2BinaryTree(o, 2*index);
            return root;
        }


        return root;
    }
    public static void main(String[] args) {
        BinaryTreeDLR dlr = new BinaryTreeDLR();
        String[] strs = {"1", "2", "3", null, "4", "5", "6"};
        Node root = dlr.array2BinaryTree(strs, 0);
        System.out.print("正序遍历: ");
        DLRiterator(root);
        System.out.print("\n" + "不知道什么遍历：");
        DLRWithStack(root);
    }
}
