package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 桌上有N张牌，正反面各有一个正整数（正反面的数可能不同）。
 *
 * 我们翻任意数量的牌，然后选一张牌。
 *
 * 如果选择的这张牌背面的数字X不在桌面上的牌的数字里，X就是好数。
 *
 * 问最小的好数是几，如果没有，就返回0。
 *
 * fronts[i] 和 backs[i] 代表桌面上第i张牌的正面和反面数字。
 *
 * 一次翻牌调换牌的正反面数字，翻完以后原来冲上的数字到了下面，原来冲下的数字到了上面。
 *
 * 思路 ： 找到最小的数字，没有任何一张牌的正反面都是这个数字，这个数字就是最小的好数。
 *
 * <p>Example:
 *
 * <p>Input: fronts = [1,2,4,4,7], backs = [1,3,4,1,3] Output: 2 Explanation: If we flip the second
 * card, the fronts are [1,3,4,4,7] and the backs are [1,2,4,1,3]. We choose the second card, which
 * has number 2 on the back, and it isn't on the front of any card, so 2 is good.
 *
 * <p>Note:
 *
 * <p>1 <= fronts.length == backs.length <= 1000. 1 <= fronts[i] <= 2000. 1 <= backs[i] <= 2000.
 */
public class CardFilipGame$M {

  public static void main(String[] args) {
    System.out.println(flipgame(new int[]{1,2,4,4,7},new int[]{1,3,4,1,3}));
  }

  public static int flipgame(int[] fronts, int[] backs) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < fronts.length; i++) {
      numbers.add(fronts[i]);
      numbers.add(backs[i]);
    }
    Collections.sort(numbers);
    for (int n : numbers) {
      boolean success = true;
      for (int i = 0; i < fronts.length; i++) {
        if (n == fronts[i] && n == backs[i]) {
          success = false;
          break;
        }
      }
      if (success) {
        return n;
      }
    }
    return 0;
  }
}
