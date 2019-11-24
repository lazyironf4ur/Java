package algorithm.leetcode.easy;

import java.util.*;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @author:Lazy1ron
 * @date:2019/11/24 8:43
 */
public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        if ("".equals(s)) {
            return -1;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        List<Node> nodeList = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            boolean flag = set.add(chars[i]);
            Node node = new Node(chars[i], i);
            if (flag) {
                nodeList.add(node);
            } else {
                if (nodeList.contains(node)) nodeList.remove(node);
            }
        }
        if (0 == nodeList.size()) {
            return -1;
        }
        return nodeList.get(0).index;
    }

    static class Node {
        public char c;
        public int index;
        public Node(char c, int index) {
            this.c = c;
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                if (this.c == ((Node) obj).c) return true;
                else return false;
            }
            return false;
        }

    }

    //TODO: 未完成
    //public static int firstUniqChar2(String s) {
    //    if ("".equals(s)) return -1;
    //    Map<Character, Integer> map = new HashMap<>();
    //    char[] chars = s.toCharArray();
    //    for (int i = 0; i < chars.length; i++) {
    //        if (map.put(chars[i], i) != null) {
    //            map.remove(chars[i]);
    //        }
    //
    //    }
    //    int index = 1000;
    //    if (map.size() == 0) return -1;
    //    for (Map.Entry entry: map.entrySet()) {
    //        if (index > (int) entry.getValue()) {
    //            index = (int) entry.getValue();
    //        }
    //    }
    //    return index;
    //}

    public static void main(String[] args) {
        //String s = "leetcode";
        //String s1 = "loveleetcode";
        //String s2 = "cc";
        //System.out.println(firstUniqChar(s));
        //System.out.println(firstUniqChar(s2));

    }
}
