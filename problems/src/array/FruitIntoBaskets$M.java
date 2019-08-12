package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 现在有一个果园，种着很多不同的树，但只有一排。现在要在一段连续果树上，摘两种果子。
 * 且这段果树只能有这两种果子。问从哪里开始摘，能摘的最多
 *
 * 求一个数组的最长连续子数组，要求这个子数组中最多只存在两个不同的元素。
 *
 * 用双指针来做
 */
public class FruitIntoBaskets$M {

  private int count = 0;
  private int max = 0;
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] trees = {3,3,3,1,2,1,1,2,3,3,4};
    System.out.println(new FruitIntoBaskets$M().totalFruit(trees));
  }

  public int totalFruit(int[] tree) {
    int left = 0;
    List<Integer> basket = new ArrayList<>();
    basket.add(tree[0]);
    for (int right=1;right<tree.length;){
      if (basket.size() < 2){
        if (!basket.contains(tree[right])){
          basket.add(tree[right]);
        }
        right ++;
      }else {
        if (!basket.contains(tree[right])){
          max = Math.max(max,right-left);
          left = right = left + 1;
          basket.clear();
        }else {
          right++;
          max = Math.max(max,right-left);
        }
     }
    }
    return max;
  }
}
