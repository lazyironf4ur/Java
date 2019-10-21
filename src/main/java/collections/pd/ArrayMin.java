package collections.pd;

/**
 * @author:Lazy1ron
 * @date:2019/9/2 15:05
 */
public class ArrayMin {

    static <T extends Number & Comparable<? super T>> T min(T[] values) {
        T t = values[0];
        for (int i = 1; i < values.length; i++) {
            if (t.compareTo(values[i]) > 0) t = values[i];
        }
        return t;
    }

    public static void main(String[] args) {

        Integer a[] = {9, 8, 4, 7, -1, -3, 11, 56};
//        String[] strings = {"niko", "s1mple", "dev1ce"};
        Float[] floats = {10.05f, 54.66f, -10.81f, -32.10f};

        int min = min(a);
//      String str = min(strings);
        float f = min(floats);
        System.out.println("min int: " + min);
        System.out.println("min float: " + f);
    }
}
