package sort;

import java.util.Arrays;

/**
 * 理解 ： 假设已经有一个有序序列，然后把一个一个的数字插入到这个有序序列中
 * Created by wei
 * Date 2017/12/20
 */
public class insertSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 8, 9, 0, 4, 5, 1, 6, 8, 7};
        sort( array );
        System.out.println( Arrays.toString(array));
    }

    private static void sort(int[] array) {
        for (int i=1;i<array.length;i++){
            int j = i - 1;
            int temp = array[i];
            while (j>=0&&array[j]>temp){
                array[j+1] = array[j];//往后移一位
                j--;
            }
            array[j+1] = temp;
        }
    }
}
