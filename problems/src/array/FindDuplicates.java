package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 */
public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        quickSort(0,nums.length-1,nums);
        List<Integer> res = new ArrayList<>();
        for (int i=1;i<nums.length;i++){
            if (nums[i] == nums[i-1])
                res.add(nums[i]);
        }
        return res;
    }

    private void quickSort(int left,int right,int[] nums){
        if (left > right)
            return;
        int start = left;
        int end = right;
        int temp = nums[left];
        while (start!=end){
            while (start<end && nums[end] >= temp)//要先动end
                end--;
            while (start<end && nums[start] <= temp)
                start++;
            if (start<end){
                int t = nums[start];
                nums[start] = nums[end];
                nums[end] = t;
            }
        }
        nums[left] = nums[start];
        nums[start] = temp;
        quickSort(left,start-1,nums);
        quickSort(start+1,right,nums);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,1};
        System.out.println(new FindDuplicates().findDuplicates(array));
    }
}
