package algorithm.sort;

/**
 * @author:Lazy1ron
 * @date:2019/9/4 18:20
 */
public class BubbleSort {
    public static void sort(int[] x) {
        for (int i = x.length-2; i >= 0; i--) {
            for (int j = i; j < x.length-1; j++) {
                int temp;
                if (x[j] > x[j+1]) {
                    temp = x[j+1];
                    x[j+1] = x[j];
                    x[j] = temp;
                }
            }
            System.out.printf("第%d次排序：", x.length-i-1);
            for (int z: x) System.out.print(z);
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int x[] = {8,6,7,9,1,5,4,3,2};
        sort(x);
    }
}
