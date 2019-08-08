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
    String best = null;
    for (int i=0;i<list1.length;i++){
      for (int j=0;j<list2.length;j++){
        if (list1[i].equals(list2[j])){
          if (min > i+j || min == i+j){
            min = i+j;
            result.add(list1[i]);
          }
        }
      }
    }
    return result.toArray(new String[result.size()]);
  }
}
