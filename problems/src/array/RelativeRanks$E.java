package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 09/02/2018. Given scores of N athletes, find their relative
 * ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal",
 * "Silver Medal" and "Bronze Medal".
 *
 * <p>Example 1: Input: [5, 4, 3, 2, 1] Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4",
 * "5"] Explanation: The first three athletes got the top three highest scores, so they got "Gold
 * Medal", "Silver Medal" and "Bronze Medal". For the left two athletes, you just need to output
 * their relative ranks according to their scores. Note: N is a positive integer and won't exceed
 * 10,000. All the scores of athletes are guaranteed to be unique.
 *
 * 根据N名运动员的得分，找到他们的相对等级和得分最高的三个人，他们将获得奖牌：“金牌”，“银牌”和“铜牌”。例如：
 *
 * 输入：[5,4,3,2,1]
 *
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 *
 * 说明：前三名运动员获得前三名最高分，因此获得“Gold Medal”，“Silver Medal”和“Bronze Medal”。对于剩下的两名运动员，你只需要根据他们的分数输出他们的相对等级。
 */
public class RelativeRanks$E {

  class Position {
    int score, poisition;

    Position(int score, int position) {
      this.score = score;
      this.poisition = position;
    }
  }
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {5, 4, 3, 2, 1};
    String[] S = new RelativeRanks$E().findRelativeRanks(A);
    for (String i : S) {
      System.out.println(i);
    }
  }

  public String[] findRelativeRanks(int[] nums) {
    String[] S = new String[nums.length];
    List<Position> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      list.add(new Position(nums[i], i));
    }
    list.sort((o1, o2) -> Integer.compare(o2.score, o1.score));
    // Collections.reverse(list);
    for (int i = 0; i < list.size(); i++) {
      if (i == 0) {
        S[list.get(i).poisition] = "Gold Medal";
      } else if (i == 1) {
        S[list.get(i).poisition] = "Silver Medal";
      } else if (i == 2) {
        S[list.get(i).poisition] = "Bronze Medal";
      } else {
        S[list.get(i).poisition] = String.valueOf(i + 1);
      }
    }
    return S;
  }
}
