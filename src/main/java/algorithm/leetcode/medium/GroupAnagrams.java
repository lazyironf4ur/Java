package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author:Lazy1ron
 * @date:2020/6/29 16:04
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时：
 * 973 ms
 * , 在所有 Java 提交中击败了
 * 5.12%
 * 的用户
 * 内存消耗：
 * 42.8 MB
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> group = new ArrayList<>();
        String[] sortStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            byte[] b = strs[i].getBytes();
            for (int k = b.length; k > 1; k--) {
                for (int j = 1; j < k; j++) {
                    if (b[j] < b[j-1]) {
                        int temp = b[j];
                        b[j] = b[j-1];
                        b[j-1] = (byte) temp;
                    }
                }
            }
            sortStrs[i] = new String(b);
        }
        List<String> list = new ArrayList<>(strs.length);
        List<String> oldList = new ArrayList<>(strs.length);
        Collections.addAll(list, sortStrs);
        Collections.addAll(oldList, strs);
        while (list.size() > 0) {
            int i = 0;
            List<String> lit = new ArrayList<>();
            for (int j = i+1; j < list.size(); j++) {

                if (list.get(i).equals(list.get(j))) {
                    lit.add(oldList.get(j));
                    list.remove(j);
                    oldList.remove(j);
                    j--;
                }
            }
            lit.add(oldList.get(i));
            list.remove(i);
            oldList.remove(i);
            group.add(lit);
        }


        return group;

    }

    public static void main(String[] args) {
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] test2 = {"","","",""};
        String[] test3 = {"tea","","eat","","tea",""};
        GroupAnagrams ga = new GroupAnagrams();
        //List list = ga.groupAnagrams(test1);
        //List list = ga.groupAnagrams(test2);
        List list = ga.groupAnagrams(test3);
        list.forEach(System.out::println);

    }
}
