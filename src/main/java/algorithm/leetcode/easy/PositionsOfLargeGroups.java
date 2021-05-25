package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Lazy1ron
 * @date:2020/6/27 15:53
 */
public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String s) {
        String str = s + "A";
        List<List<Integer>> groups = new ArrayList<>();
        int len = 0;
        int start, end;
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i+1]) {
                len = len + 1;
            } else if (len > 1) {
                List<Integer> posi = new ArrayList<>();
                end = i;
                start = end - len;
                posi.add(start);
                posi.add(end);
                groups.add(posi);
                len = 0;
            } else len = 0;

        }

        return groups;
    }

    public static void main(String[] args) {
        List<List<Integer>> results = new ArrayList<>();
        PositionsOfLargeGroups groups = new PositionsOfLargeGroups();
        results = groups.largeGroupPositions("aaasaadwdwwwww");
        results.forEach(System.out::println);
    }
}
