package dynamic_programming;

import java.util.Arrays;
import java.util.List;

/**
 * 139. 单词拆分
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 思路二:自底向上,
 *
 * dp[i]表示s到i位置是否可以由wordDict组成
 *
 * 所以有 如果dp[i - j]是true并且s[j:i]在wordDict里, 那么dp[i] = true;
 *
 * 两种都很容易理解的!看代码就行了
 */
public class WordBreak$$retry {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) return s.isEmpty();
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i=1;i<=s.length();i++){
            for (int j=i-1;j>=0;j--){
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = Arrays.asList("leet", "code");
        System.out.println(new WordBreak$$retry().wordBreak(s,list));
    }
}
