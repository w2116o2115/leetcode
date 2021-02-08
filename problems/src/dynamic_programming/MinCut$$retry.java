package dynamic_programming;

/**
 * 132. 分割回文串 II
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回符合要求的最少分割次数。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 * dp[i]：表示前缀子串 s[0:i] 分割成若干个回文子串所需要最小分割次数。
 * 状态方程推导：
 *         如果 s[0:i] 本身就是一个回文串，那么不用分割，即 dp[i] = 0
 *         s[0:i] 本身不是一个回文串，就尝试分割，枚举分割的边界 j
 *           如果 s[j + 1, i] 不是回文串，尝试下一个分割边界。
 *           如果 s[j + 1, i] 是回文串，则 dp[i] 就是在 dp[j] 的基础上多一个分割。
 *           dp[i] = Math.min(dp[i],dp[j]+1);
 */
public class MinCut$$retry {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        isPal(s,isPal);
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        for (int i=1;i<n;i++){
            if (isPal[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j=0;j<i;j++){
                if (isPal[j+1][i]){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }

    private void isPal(String s, boolean[][] isPal) {
        int n = s.length();
        for (int len = 1;len<n;len++){
            for (int start = 0;start<n;start++){
                int end = start+len-1;
                if (end >= n) break;
                if ((len == 1 || len == 2 || isPal[start+1][end-1]) && s.charAt(start) == s.charAt(end)){
                    isPal[start][end] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinCut$$retry().minCut("aab"));
    }
}