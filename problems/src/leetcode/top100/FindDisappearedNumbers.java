package leetcode.top100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 448. 找到所有数组中消失的数字
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * 思路：把数组当字典      记录出现的数字【吧改位置的数变为负的】
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        for (int i=1;i<=nums.length;i++){
            if (!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        //n和下标n-1 一一对应
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            //数都是正的，该位置可能已被修改为负的，所以
            int n = Math.abs(nums[i]);
            //有可能已经出现过【表现为数为负的】，让所有出现的n对应的下标n-1的元素为负
            nums[n-1]=-Math.abs(nums[n-1]);
        }
        //返回所有 没有修改的数的下标+1
        for (int i=0; i<nums.length; i++)
            if (nums[i]>0) list.add(i+1);
        return list;

    }

    public static void main(String[] args) {
        System.out.println(new FindDisappearedNumbers().findDisappearedNumbers2(new int[]{4,3,2,7,8,2,3,1}));
    }
}
