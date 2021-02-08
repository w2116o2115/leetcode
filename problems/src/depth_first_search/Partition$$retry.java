package depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 思路二: 动态规划 + 回溯
 */
public class Partition$$retry {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) dp[j][i] = true;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        dfs(res, dp, 0, n, s, new ArrayList<>());
        return res;

    }

    private void dfs(List<List<String>> res, boolean[][] dp, int i, int n, String s, ArrayList<String> tmp) {
        if (i == n) res.add(new ArrayList<>(tmp));
        for (int j = i; j < n; j++) {
            if (dp[i][j]) {
                tmp.add(s.substring(i, j + 1));
                dfs(res, dp, j + 1, n, s, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Partition$$retry().partition("aab"));
    }
}
