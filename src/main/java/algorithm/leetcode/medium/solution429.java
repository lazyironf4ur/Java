package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Lazy1ron
 * @date:2021/3/9 15:13
 */
public class solution429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Node now;
        if(root != null) {
            List<Integer> vals = new ArrayList<>();
            vals.add(root.val);
            result.add(vals);
            result.add(null);
            now = root;
            while (now.children != null) {
                        List<Integer> values = new ArrayList<>();
                        int len = now.children.size();
                        Node son;
                        for(int i = 0; i < len; i++ ) {

                            values.add(now.children.get(i).val);
                            result.add(values);
                            result.add(null);
                }



            }
        }
        return result;
    }
}
