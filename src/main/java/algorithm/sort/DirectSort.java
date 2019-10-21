package algorithm.sort;

/**
 * @author:Lazy1ron
 * @date:2019/9/4 17:56
 */
public class DirectSort {
    public static void sort(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = i+1; j < x.length ; j++) {
                int temp;
                if (x[i] > x[j]) {
                    temp = x[j];
                    x[j] = x[i];
                    x[i] = temp;
                }
            }
            System.out.printf("第%d次排序:", i);
            for (int z: x) System.out.print(z);
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[] array = {9,8,4,5,7,6,3,1,2};
        sort(array);

    }
}
