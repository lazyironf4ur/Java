package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author:Lazy1ron
 * @date:2019/9/2 10:24
 */
public class CollectionUtils {
    private static ArrayList<Integer> list = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Origin List: " + list);

        Collections.reverse(list);
        System.out.println("Reverse List: " + list);

        Collections.reverse(list);
        Collections.shuffle(list);
        System.out.println("Shuffle List: " + list);

        Collections.sort(list);
        System.out.println("Sort List: " + list);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("Other Sort List: " + list);

        int index = Collections.binarySearch(list, 4);
        System.out.println("Index Of '4': " + index);
    }
}
