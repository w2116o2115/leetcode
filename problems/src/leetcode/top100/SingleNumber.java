package leetcode.top100;

import java.util.Arrays;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 任何数与 0 异或都不改变它的值，即 a^0=a
 * 任何数与其自身异或都为 0，即 a^a=0
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i=1;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{4,-1,2,-1,2}));
    }

}
