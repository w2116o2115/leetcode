package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * 加Map去重
 */
public class PermutationsII$M {
  public static void main(String[] args) {
    int[] A = {1, 1, 2};
    System.out.println(new PermutationsII$M().permute(A));
    System.out.println(1);
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int[] visited = new int[nums.length];
    nextPermutation(nums, result , new Stack<>(),visited);
    return result;
  }

  private void nextPermutation(int[] nums, List<List<Integer>> result,Stack<Integer> stack,int[] visited) {
    if (stack.size() == nums.length){
      result.add(new ArrayList<>(stack));
      return;
    }

    for (int i=0;i<nums.length;i++){
      if (visited[i] == 1) continue;
      if (i>0 && nums[i] == nums[i-1] && visited[i-1]==0) continue;
      visited[i] = 1;
      stack.add(nums[i]);
      nextPermutation(nums,result,stack,visited);
      visited[i] = 0;
      stack.pop();
    }
  }
}
