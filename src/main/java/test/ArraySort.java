package test;

import design.AbstractCsPlayer;

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
            AbstractCsPlayer csp1 = (AbstractCsPlayer) o1;
            AbstractCsPlayer csp2 = (AbstractCsPlayer) o2;
            return csp1.getAge().compareTo(csp2.getAge());
        }
    }



    public static void main(String[] args) {


    }
}
