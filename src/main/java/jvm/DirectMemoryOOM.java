package jvm;

//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;



import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author:Lazy1ron
 * @date:2020/7/26 2:27
 *
 * vm Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {


    private static final int _10MB = 1024*1024*10;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);

        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_10MB);
        }
    }
}
