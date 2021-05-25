package jvm;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * PermSize & MaxPermSize was removed in jdk8
 * @author:Lazy1ron
 * @date:2020/7/25 18:23
 */
public class RuntimeContantPoolOOM {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        short i = 0;
        while (true) {
            set.add(String.valueOf(i).intern()) ;
        }
    }
}
