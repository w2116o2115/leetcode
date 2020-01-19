package backtracking;

import java.util.*;

/**
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 *
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 *
 * 解释: 不能用所有火柴拼成一个正方形。
 *
 * 1.若是nums中数量小于4个，则直接返回false，若nums所有数的和都除以4有余数，则直接返回false
 * 2.对nums数组进行从大到小的排序，这样相当于剪枝，回溯法的时候可以省去一些尝试。
 * 3.用数组存放四个值，相当于四个桶，然后把数值依次存入桶中。然后用深度优先搜素依次遍历，数组中的所有数，
 *   依次放入四个桶中，若桶中数值之和加上遍历到数之后和大于sum/4，则放入一个桶尝试，放入完成该数后，再尝试
 *   下一个数，若所有数都放置完成，并且每个桶中的和等于sum/4，则返回true，否则，返回false。
 */
public class MatchsticksToSquare$M {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] A = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 6, 10, 10};
    System.out.println(new MatchsticksToSquare$M().makesquare(A));
  }

  public boolean makesquare(int[] nums) {
    int sum = 0;
    for(int num : nums)
      sum += num;
    if(sum == 0 || sum%4 != 0)
      return false;
    int target = sum/4;

    for(int num : nums)
      if(num > target)
        return false;
    //从大到小的回溯，效率更高
    Arrays.sort(nums);
    backtrack(nums.length-1,nums,target,new int[4]);
    return ans;

  }
  boolean ans = true;
  void backtrack(int cur,int[]nums,int target,int[] temp) {
    if (cur == -1){
      for (int num : temp){
        if (num != target)
          ans = false;
        return;
      }
    }
    for (int i=0;i<temp.length;i++){
      int last = temp[i];
      temp[i] += nums[cur];
      if (temp[i] <= target){
        backtrack(cur-1,nums,target,temp);
      }
      temp[i] = last;
    }
  }
}
