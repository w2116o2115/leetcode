package leetcode.top100;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 快排 partition 思想!!
 */
public class FindKthLargest$$$$retry {
    public int findKthLargest(int[] nums, int k) {

        return partition(nums, nums.length-k, 0, nums.length-1);
    }


    public int partition(int[] nums, int k, int s, int e) {
        int i = s;
        int j = e;
        int flag = nums[s];
        while(i<j) {
            while(i<j && nums[j]>=flag) {
                j--;
            }
            swap(nums, i, j);
            while(i<j && nums[i]<=flag) {
                i++;
            }
            swap(nums, i, j);
        }
        if(i == k) return flag;
        else if(i > k) return partition(nums, k, s, i-1);
        else return partition(nums, k, i+1, e);
    }



    public void swap(int[] N, int i, int j) {
        int tmp = N[i];
        N[i] = N[j];
        N[j] = tmp;
    }
}
