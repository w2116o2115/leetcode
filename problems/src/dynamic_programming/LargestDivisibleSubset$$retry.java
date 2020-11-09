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
 * 思路：这道题先对数组由大到小排序，如果满足nums[i]%nums[i+1]==0，那么nums[i+1]一定可以被能整除nums[i]的所有元素整除，
 * 所以如果满足nums[i]%nums[i+1]==0并且dp[i]+1>=dp[i+1]（dp是我们维护的递推数组，dp[i]表示到第i个元素最大的子集的个数），
 * 就更新dp[i+1]=dp[i]+1，递推公式就这么简单，但是本文需要求出集合的元素，而不仅仅是个数。所以我们还需要记录哪个dp[i]是最大的并且记录dp[i]对应子集是什么。
 *
 * 对于记录哪个dp[i]最大，可以用一个global_max来记录即可，但是如何记录每个dp[i]的子集呢，我们需要另外一个parent递推数组，
 * 如果满足nums[i]%nums[i+1]==0并且dp[i]+1>=dp[i+1]的条件，我们就更新parent[i+1]=i，parent[k]=q的意思是记录第k个元素的
 * 最大子集开始的下标是q，有了开始下标就可以利用回溯的思想进行返回查找，比如我们最后记录到dp[15]有最大的子集，并且dp[15]=4，
 * 意味着有4个子集，那我们利用如下公式回溯4个子集：
 *
 * for (int i = 0; i < mx; i++) {
 * 	res.push_back(nums[mx_index]);
 * 	mx_index = parent[mx_index];
 */
public class LargestDivisibleSubset$$retry {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[]dp = new int[nums.length];
        int[]pre = new int[nums.length];
        int max = 1;
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        Arrays.fill(pre,-1);
        int index = 0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                    if (max < dp[i]){
                        max = dp[i];
                        index =  i;
                    }
                }
            }
        }
        while (index != -1){
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,8};
        System.out.println(new LargestDivisibleSubset$$retry().largestDivisibleSubset(nums));
    }
}
