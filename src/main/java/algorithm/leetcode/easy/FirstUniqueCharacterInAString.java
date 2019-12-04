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
        int index = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            boolean flag = set.add(chars[i]);
            if (flag) {
                index ++;
                continue;
            } else {
                if (index > 0) {
                    for (int j = 0; j < index; j++) {
                        if (chars[j] == chars[i]) chars[j] = ' ';
                    }
                } else return -1;
            }
        }
        for (int z = 0; z < chars.length; z++) {
            if (chars[z] != ' ') return z;
        }

        return -1;

    }

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
        String s = "leetcode";
        String s1 = "loveleetcode";
        String s2 = "cc";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar(s2));

    }
}
