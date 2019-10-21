package collections;

import inherit.Son;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author:Lazy1ron
 * @date:2019/9/3 11:34
 */
public class HashST {

    private static Map<String, Object> map = new HashMap<>();
    private static Map<Object, String> remap = new HashMap<>();

    public static void main(String[] args) {
        map.put("niko", new Son("niko", 22));
        map.put("s1mple", new Son("s1mple", 20));
        map.put("zeus", new Son("zeus", 25));
        remap.put(new Son("niko", 22), "niko");
        remap.put(new Son("s1mple", 20), "s1mple");
        remap.put(new Son("zeus", 25), "zeus");

        for (Map.Entry entry: map.entrySet()) {
            Son son = (Son) entry.getValue();
            System.out.println("name: " + son.getName() + ", age: " + son.getAge());
        }

        TreeMap treeMap = new TreeMap(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                Son son1 = (Son) o1.getValue();
                Son son2 = (Son) o2.getValue();
                int flat = son1.getAge() - son2.getAge();
                return flat;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        treeMap.putAll(remap);
        treeMap.forEach((k, v) -> System.out.println("key:" + k + ", value: " + v));
    }
}
