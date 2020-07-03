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
    List<Integer> list = new ArrayList<>();
    for (int num : nums){
      list.add(num);
    }
    nextPermutation(list, result , new Stack<>());
    return result;
  }

  private void nextPermutation(List<Integer> nums, List<List<Integer>> result,Stack<Integer> stack) {
    if (nums == null || nums.size() == 0) result.add(new ArrayList<>(stack));
    for (int i=0;i<nums.size();i++){
      if (i>0 && nums.get(i).equals(nums.get(i - 1))) continue;
      stack.add(nums.get(i));
      List<Integer> copyList = new ArrayList<>(nums);
      copyList.remove(i);
      nextPermutation(copyList,result,stack);
      stack.pop();
    }
  }
}
