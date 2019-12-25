package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *
 * 如果有多个目标子集，返回其中任何一个均可。
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 *
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 * 约定函数接口: List<Integer> largestDivisibleSubset(int[] nums)
 *
 * 预处理: 对nums进行升序排序
 *
 * dp[i]: 表示以nums[i]为最大元素的整除子集的最大长度
 *
 * 状态转移方程:
 * 	显然,
 * 	dp[i]=max(dp[i],dp[j]+1),(0<=j<i && nums[i]%nums[j]==0).
 *
 * 初始状态:
 * 	dp[i]=1;
 *
 * 复杂度分析:
 * 时间复杂度: O(n2);
 * 空间复杂度: O(n)
 *
 * Plus: 本题还要求求出具体的集合,将dp过程记忆化便可.
 * pre[i]: 表示以nums[i]为最大元素的最大整除子集第二大元素在nums数组的索引.
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums.length == 0) return ans;
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        int maxx = 0;
        int idx = -1;
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        Arrays.fill(pre,-1);
        maxx = 1;
        idx = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                    if(maxx < dp[i]) {
                        maxx = dp[i];
                        idx = i;
                    }
                }
            }
        }
        while(idx != -1) {
            ans.add(nums[idx]);
            idx = pre[idx];
        }
        return ans;
    }
}
