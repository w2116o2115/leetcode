package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 583. 两个字符串的删除操作
 * <p>
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 *
 * LongestCommonSubsequence
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        Map<Character, Integer> set1 = new HashMap<>();
        Map<Character, Integer> set2 = new HashMap<>();
        for (char c : word1.toCharArray())
            if (set1.containsKey(c)) {
                set1.put(c, set1.get(c) + 1);
            } else {
                set1.put(c, 1);
            }
        for (char c : word2.toCharArray()) {
            if (set2.containsKey(c)) {
                set2.put(c, set2.get(c) + 1);
            } else {
                set2.put(c, 1);
            }
        }
        set1.forEach((k, v) -> {
            if (set2.containsKey(k) && set2.get(k) >= 1 && v >= 1) {
                int min = Math.min(set1.get(k), set2.get(k));
                set1.put(k, v - min);
                set2.put(k, set2.get(k) - min);
            }
        });
        int count1 = 0, count2 = 0;
        for (Map.Entry entry : set1.entrySet()) {
            count1 = count1 + (int) entry.getValue();
        }

        for (Map.Entry entry : set2.entrySet()) {
            count2 = count2 + (int) entry.getValue();
        }

        return count1 + count2;
    }

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("industry","interest"));
    }
}
