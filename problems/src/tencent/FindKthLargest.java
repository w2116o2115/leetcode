package tencent;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 优先队列（用堆）
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        for (int i=nums.length/2-1;i>=0;i--){
            adJustHeap(nums,i,nums.length);
        }
        int count = 0;
        for (int i=nums.length-1;i>=0;i--){
            if (++count == k) return nums[nums.length-i-1];
            adJustHeap(nums,0,i);
        }
        return 0;
    }

    private static void adJustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for (int k=2*i+1;k<length;k=2*k+1){
            if (k+1<length && arr[k+1]>arr[k]){
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(new FindKthLargest().findKthLargest(nums,2));
    }
}