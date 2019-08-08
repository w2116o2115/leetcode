package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 假设Andy和Doris想要选择一家餐馆吃晚餐，他们都有一个最受欢迎的餐馆列表。你需要用最少的列表索引总和帮助他们找出他们的共同兴趣。
 * 如果答案之间存在选择关系，则输出所有答案并且没有顺序要求。你可以假设总有一个答案。例如：
 *
 * 输入:
 *
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 *
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 *
 * 输出: ["Shogun"]
 *
 * 说明: 他们都喜欢的唯一一家餐厅是“Shogun”。
 *
 *
 * 输入:
 *
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 *
 * ["KFC", "Shogun", "Burger King"]
 *
 * 输出: ["Shogun"]
 *
 * 说明: 他们喜欢并且索引总和最少的餐馆是“Shogun”，索引和1（0 + 1）。
 */
public class MinimumIndexSumOfTwoLists$E {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) throws Exception {
    String[] A1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] A2 = {"Tapioca Express", "Shogun", "Burger King"};
    String[] ans = new MinimumIndexSumOfTwoLists$E().findRestaurant(A1, A2);
    for (String s : ans) {
      System.out.println(s);
    }
  }

  public String[] findRestaurant(String[] list1, String[] list2) {
    int min = Integer.MAX_VALUE;
    List<String> result = new ArrayList<>();
    if (list2.length == 0) return new String[0];
    Map<String, Integer> index = new HashMap<>();
    for (int i = 0; i < list2.length; i++) {
      index.put(list2[i], i);
    }
    for (int i = 0; i < list1.length; i++) {
      String s = list1[i];
      if (index.containsKey(s)) {
        int sum = i + index.get(s);
        min = Math.min(min, sum);
      }
    }

    for (int i = 0; i < list1.length; i++) {
      String s = list1[i];
      if (index.containsKey(s)) {
        int sum = i + index.get(s);
        if (sum == min) {
          result.add(s);
        }
      }
    }
    String[] resArr = new String[result.size()];
    result.toArray(resArr);
    return resArr;
  }
}
