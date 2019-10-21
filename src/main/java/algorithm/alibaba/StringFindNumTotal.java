package algorithm.alibaba;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author:Lazy1ron
 * @date:2019/9/6 16:42
 *
 * 实现在一个字符串中找到出现最多的整数并求和
 */
public class StringFindNumTotal {

    public static Integer func(String s) {
        int num = 0, cout = 0;
        Map<Integer, Integer> map = new HashMap<>();
        String[] strings = s.split("[^0-9]");
        for (int i = 0; i < strings.length; i++) {
            if (!"".equals(strings[i])) {
                int key = Integer.valueOf(strings[i]);
                if (map.containsKey(key)) {
                    cout = map.get(key);
                    map.put(key, cout + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }
        List<Map.Entry> sortList = new ArrayList<>();
        sortList.addAll(map.entrySet());
        Collections.sort(sortList, new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                Integer value1 = (Integer) (o1.getValue());
                Integer value2 = (Integer) (o2.getValue());
                return value2 - value1;
            }
        });

        if (sortList != null) {
            int value;
            Map.Entry entry = sortList.get(0);
            num = (int) entry.getKey();
            value = (int) entry.getValue();
            return num * value;
        }
        return null;
    }


    public static void main(String[] args) {
        String s = "4648d86sw86ws82sasw0j86j";
        System.out.println(func(s));
    }
}
