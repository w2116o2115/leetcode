package leetcode.top250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 229. 求众数 II
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length / 3;
        Arrays.sort(nums);
        int count = 0;
        Integer pre = null;
        for (int num:nums){
            if (pre == null){
                pre = num;
                count++;
            }else {
                if (pre.equals(num)){
                    count++;
                }else {
                    if (count > n) res.add(pre);
                    count = 1;pre = num;
                }
            }
        }
        if (count > n) res.add(pre);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3,2,3}));
    }
}
