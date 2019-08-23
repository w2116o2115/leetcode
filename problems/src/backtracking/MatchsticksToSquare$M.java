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
 * 由于每一根火柴都要用上，那么如果可以组成一个正方形，那这个正方形一定是一个确定的，其边长为火柴长度和除4。
 * 通过这一点我们可以先排除一些不可能的情况： 火柴和不是4的倍数 最长的火柴大于边长 给定数组元素个数小于4 接下来我们将火柴从小到大排序
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
