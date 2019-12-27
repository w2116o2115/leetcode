package top100;

import dynamic_programming.zeroOrOneknapsack.SubsetSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 78. 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        bankTrade(0,new Stack<Integer>(),nums);
        return res;
    }

    private void bankTrade(int index, Stack stack,int[] nums){
        res.add(new ArrayList<>(stack));

        for (int i=index;i<nums.length;i++){
            stack.push(nums[i]);
            bankTrade(i+1,stack,nums);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }
}
