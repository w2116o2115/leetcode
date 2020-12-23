package sort;

import java.util.Arrays;

/**
 * 希尔拍讯 就是根据gap（步长） 分组进行insert拍讯
 * {n/2,(n/2)/2...1}，称为增量序列
 * Created by wei
 * Date 2017/12/21
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5, 8, 9, 0, 4, 5, 1, 6, 8, 7};
        sort( array);
        System.out.println( Arrays.toString( array ) );
    }

    private static void sort(int[] array) {
        for (int gap=array.length/2;gap>0;gap/=2){
            for (int i=gap;i>0;i--){
                for (int j=i+gap;j<array.length;j+=gap){
                    int temp = array[j];
                    int k = j - gap;
                    while (k>=0&&array[k]>temp){
                        array[k+gap] = array[k];
                        k-=gap;
                    }
                    array[k+gap] = temp;
                }
            }
        }
    }
}
