package array;

import java.util.*;

/**
 * 216. 组合总和 III
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(1,k,n,res,new Stack<>());
        return res;
    }

    private void backTrack(int index, int k, int n, List<List<Integer>> res, Stack<Integer> stack){
        if (n == 0 && stack.size() == k){
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i=index;i<=9;i++){
            stack.add(i);
            backTrack(i+1,k,n-i,res,stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(2,18));
    }


}