package sort;

import java.util.Arrays;

/**
 * Created by wei
 * Date 2017/12/7
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 8, 9, 0, 4, 5, 1, 6, 8, 7};
        sort( array );
        System.out.println(Arrays.toString(array));
    }

    public static int[] sort(int[] array){
        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if (array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
}
