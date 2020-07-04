package tencent;

import java.util.Arrays;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 示例 1:

 输入: [3,2,3]
 输出: 3
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int count = 1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            }else {
                count = 1;
            }
            if (count > nums.length/2) return nums[i-1];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
}
