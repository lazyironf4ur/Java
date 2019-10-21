package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:Lazy1ron
 * @date:2019/9/2 10:50
 */
public class ArrayUtils {

    private static Integer[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int[] b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(a);
        List<int[]> list2 = Arrays.asList(b);
        System.out.println("Address: " + list1);
        System.out.println("Address: " + list2);

        List<Integer> arrayList = new ArrayList<Integer>();
        arrayList = arrayToList(a);
        System.out.println("Elements: " + arrayList);


    }

    static <T> List<T> arrayToList(T[] array) {
        List<T> list = new ArrayList<>(array.length);
        for (T t: array) {
            list.add(t);
        }
        return list;
    }
}
