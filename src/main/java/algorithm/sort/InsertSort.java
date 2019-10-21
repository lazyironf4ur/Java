package algorithm.sort;

/**
 * @author:Lazy1ron
 * @date:2019/9/4 20:56
 */
public class InsertSort {
    public static void sort(int[] x) {
        int len = x.length,    //数组长度
                value,         //当前比较的值
                i,             // 未排序部分的当前位置
                j;             // 已排序部分的当前位置

        for (i = 0; i < len; i++) {
            value = x[i];
            /*
             * 当已排序部分的当前元素大于value，
             * 就将当前元素向后移一位，再将前一位与value比较
             */
            for (j = i-1; j > -1 && x[j] > value; j--) {
                x[j+1] = x[j];
            }
            x[j+1] = value;
            System.out.printf("第%d次排序：", i+1);
            for (int z: x) System.out.print(z);
            System.out.print("\n");
        }

    }

    public static void main(String[] args) {
        int x[] = {8,6,7,9,1,5,4,3,2};
        sort(x);
    }
}
