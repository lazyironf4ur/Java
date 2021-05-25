package algorithm.leetcode.easy;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.*;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @author:Lazy1ron
 * @date:2019/11/24 8:43
 */
public class FirstUniqueCharacterInAString {


    public static int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        boolean[] flags = new boolean[chars.length];
        for (int i = 0; i < chars.length - 1; i++) {
            if (flags[i] != true) {
                for (int j = i+1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        flags[i] = flags[j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] == false) return i;
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
        String s3 = "asssavffwqqwdqdqf";
        System.out.println(firstUniqChar2(s));
        System.out.println(firstUniqChar2(s1));
        System.out.println(firstUniqChar2(s2));
        System.out.println(firstUniqChar2(s3));

    }
}
