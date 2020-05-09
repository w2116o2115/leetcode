package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 给定一个只包含数字的非空字符串，请计算解码方法的总数。

 示例 1:

 输入: "12"
 输出: 2
 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 示例 2:

 输入: "226"
 输出: 3
 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

 思路 ： 变相爬楼梯问题
 */
public class NumDecodings {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,1);
        char[] c = s.toCharArray();
        for (int i=2;i<c.length;i++){
            dp[i] += c[i] == '0'?0:dp[i-1];
            if ((c[i-2] == '2' || c[i-2] == '1') && c[i-1] <= '6')
                dp[i] += dp[i-2];
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("12"));
    }
}
