package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:Lazy1ron
 * @date:2019/12/16 11:27
 */
public class ArraySort {

    static class MyComparator<T> implements Comparator<T> {

        @Override
        public int compare(T o1, T o2) {
            return -1;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }
    }

    static class MyComparable<K> implements Comparable<K> {

        @Override
        public int compareTo(K o) {
            return 1;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{9,8,15,2,4,6,16,999,457,864};

        Arrays.sort(a, new MyComparator<>());
        System.out.println(Arrays.toString(a));
        System.out.println();
    }
}
