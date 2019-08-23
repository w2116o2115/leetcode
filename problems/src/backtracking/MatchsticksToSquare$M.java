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

  class Pair {
    int value, i;

    Pair(int value, int i) {
      this.value = value;
      this.i = i;
    }
  }

  public boolean makesquare(int[] nums) {
    if (nums.length == 0) return false;
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    int side = sum / 4;
    if ((sum % 4) != 0) return false;
    List<List<Pair>> list = powerSet(nums, side);
    Set<Integer> hashIndex = new HashSet<>();
    int cons = 0;
    for (int i = 0; i < nums.length; i++) {
      cons |= (1 << i);
    }
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        Set<Integer> indexList = new HashSet<>();
        List<Pair> list1 = list.get(i);
        List<Pair> list2 = list.get(j);
        int hash = 0;
        for (Pair l1 : list1) {
          indexList.add(l1.i);
          hash |= (1 << l1.i);
        }
        boolean allUnique = true;
        for (Pair l2 : list2) {
          if (indexList.contains(l2.i)) {
            allUnique = false;
            break;
          }
          indexList.add(l2.i);
          hash |= (1 << l2.i);
        }
        if (allUnique) {
          hashIndex.add(hash);
          int complement = ((~hash) & cons);
          if (hashIndex.contains(complement)) return true;
        }
      }
    }
    return false;
  }

  private List<List<Pair>> powerSet(int[] nums, int expectedSum) {
    List<List<Pair>> result = new ArrayList<>();
    generate(0, nums, new ArrayList<>(), result, 0, expectedSum);
    return result;
  }

  private void generate(
      int i, int[] nums, List<Pair> subList, List<List<Pair>> result, int sum, int expected) {
    if (i >= nums.length) {
      if (sum == expected) {
        List<Pair> pairs = new ArrayList<>(subList);
        result.add(pairs);
      }
    } else {
      if (sum + nums[i] <= expected) {
        subList.add(new Pair(nums[i], i));
        generate(i + 1, nums, subList, result, sum + nums[i], expected);
        subList.remove(subList.size() - 1);
      }
      generate(i + 1, nums, subList, result, sum, expected);
    }
  }
}
