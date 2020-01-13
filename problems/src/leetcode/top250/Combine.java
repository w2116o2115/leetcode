package leetcode.top250;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i=1;i<=n;i++)
            nums[i-1] = i;
        List<List<Integer>> res = new ArrayList<>();
        bankTrack(0,nums,k,new Stack<>(),res);
        return res;
    }

    private void bankTrack(int index, int[] nums, int k, Stack<Integer> stack,List<List<Integer>> res){
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = index;i<nums.length;i++){
            stack.add(nums[i]);
            bankTrack(i+1,nums,k,stack,res);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4,2));
    }
}
