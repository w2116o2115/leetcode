package array;

/**
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 返回仅包含 1 的最长（连续）子数组的长度。

 示例 1：

 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 输出：6
 解释：
 [1,1,1,0,0,1,1,1,1,1,1]
 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 思路 ： 滑动窗口 + 前缀和
 */
public class LongestOnes$$retry {
    public int longestOnes(int[] A, int K) {
        int lo=0,hi=0;
        int  preSum = 0;
        int n = A.length;
        int res = 0;
        for (hi = 0;hi<n;hi++){
            preSum += (A[hi]==0?1:0);
            if (preSum > K){ // 需要移动窗口
                while (lo < hi && A[lo] == 1){
                    lo++;
                }
                preSum -= 1;
                lo++;
            }
            if (hi - lo + 1 > res)
                res = hi - lo + 1;
        }
        return res;
    }
}
