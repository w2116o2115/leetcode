package tencent;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 78. 子集
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
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(0,res,new Stack<>(),nums);
        return res;
    }

    private void backTrack(int index, List<List<Integer>> res, Stack<Integer> stack,int[] nums){
        res.add(new ArrayList<>(stack));

        for (int i=index;i<nums.length;i++){
            stack.add(nums[i]);
            backTrack(i+1,res,stack,nums);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new Subsets().subsets(nums));
    }
}