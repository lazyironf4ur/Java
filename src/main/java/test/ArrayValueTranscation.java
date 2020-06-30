package test;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author:Lazy1ron
 * @date:2020/6/29 16:48
 */
public class ArrayValueTranscation {

    public static void test1(byte[] strs) {
        byte temp = strs[0];
        strs[0] = strs[1];
        strs[1] = temp;
    }

    public static void main(String[] args) {
        byte[] strings = {'a','b','c'};
        byte[] strings2;
        strings2 = strings;
        //String[] strings2 = strings;
        test1(strings2);
        System.out.println(Arrays.toString(strings));
    }
}
