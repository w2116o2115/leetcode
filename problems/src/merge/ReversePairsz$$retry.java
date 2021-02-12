package merge;

/**
 * 493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 你需要返回给定数组中的重要翻转对的数量。

 输入: [1,3,2,3,1]
 输出: 2

 思路 : 归并
 */
public class ReversePairsz$$retry {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums,0,n-1);
    }

    private int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = (lo+hi) >> 1;
        int res = 0;
        res += mergeSort(nums,0,mid);
        res += mergeSort(nums,mid+1,hi);
        res += merge(nums,lo,mid,hi);
        return res;
    }

    private int merge(int[] nums, int lo, int mid, int hi) {
        int count = 0;
        int[] a = new int[hi - lo + 1];
        int p = lo,q = mid+1;
        while (p <= mid && q <= hi){
            if (nums[p] > 2* nums[q]){
                count+= mid-p+1;
                q++;
            }else {
                p++;
            }
        }
        p = lo;
        q = mid + 1;
        int index = 0;
        while (p <= mid && q <= hi){
            if (nums[p]>nums[q]){
                a[index++] = nums[q++];
            }else {
                a[index++] = nums[p++];
            }
        }

        while (p <= mid){
            a[index++] = nums[p++];
        }
        while (q <= hi){
            a[index++] = nums[q++];
        }
        System.arraycopy(a,0,nums,lo,hi-lo+1);
        return count;
    }
}
