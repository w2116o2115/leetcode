package sort;

import java.util.Arrays;

/**
 * 分治递归思想
 * Created by wei
 * Date 2017/12/22
 */
public class MergeSort {
    private static void merge(int[] array,int low,int mid,int hight){
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] array2 = new int[hight-low+1];
        while (i<=mid&&j<=hight){
            if (array[i]<array[j]){
                array2[k] = array[i];
                i++;k++;
            }else {
                array2[k] = array[j];
                j++;k++;
            }
        }
        while (i<=mid){
            array2[k] = array[i];
            i++;k++;
        }
        while (j<=hight){
            array2[k] = array[j];
            j++;k++;
        }
        for (k=0,i=low;i<=hight;i++,k++){
            array[i] = array2[k];
        }
    }

    private static int[] sort(int[] array,int low,int hight){
        int mid = (low+hight)/2;
        if (low<hight){
            sort( array,low,mid );
            sort( array,mid+1,hight );
            merge( array,low,mid,hight);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {
                9, 1, 5, 3, 4, 2, 6, 8, 7
        };
        int[] sorted = sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString( sorted ));
    }
}