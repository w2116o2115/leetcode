package string;

import java.util.Arrays;

/**
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 根据出现次数排序 【通过】
 *
 * 如果要让 'a' 不连续，很自然可以写出 "aXaXaXa..." 这种形式，其中 "X" 是除了 'a' 之外的字符。现在假设有一种排列方式可以使得任意两相邻字符不同，我们来找出这种排列方式。
 *
 * 首先将 S 进行排序，排序之后所有相同的字符都连续出现了。接着以间隔的方式重新排布，如 S[3], S[0], S[4], S[1], S[5], S[2]，让相同的字符互相不相邻。
 * （这里是从下标 1 开始，每次间隔 2 来输出）
 *
 * 在 N 为偶数，下标 0 或 1 处有重复三次字符的情况下，像 S[2], S[0], S[3], S[1], S[4] 这样间隔输出是可能得不到想要的结果的。在这种情况下为了防止错误的输出，
 * 我们需要确保出现次数最多的字符要出现在重排数组的最后位置。
 *
 * 上述我们讨论的是在有这种排列的情况下如何找到，那自然也是有可能不存在这种排列的。在字符串长度为 N 的情况下，如果有一个字母出现的次数超过 (N+1) / 2，这时候就不存在这样一种排列。
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        int N = S.length();
        int[] counts = new int[26];
        for (char c: S.toCharArray()) counts[c-'a'] += 100;
        for (int i = 0; i < 26; ++i) counts[i] += i;
        //Encoded counts[i] = 100*(actual count) + (i)
        Arrays.sort(counts);

        char[] ans = new char[N];
        int t = 1;
        for (int code: counts) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (N+1) / 2) return "";
            for (int i = 0; i < ct; ++i) {
                if (t >= N) t = 0;
                ans[t] = ch;
                t += 2;
            }
        }

        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("aab"));
    }
}