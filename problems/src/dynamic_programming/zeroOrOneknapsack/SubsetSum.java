package dynamic_programming.zeroOrOneknapsack;

/**
 * 子集和问题
 *
 * 已知一个非负整数集，与sum的值，确定这个集合是否存在这样的子集，这个子集所有元素和等于sum。
 *
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 *
 * 典型的 0 1 背包问题
 */
public class SubsetSum {
    public boolean subsetSum(int[] nums,int sum){
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for (int num:nums){
            for (int i = sum;i>=num;i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[sum] >= 1;
    }

    public static void main(String[] args) {
        int[] set = new int[]{3, 34, 4, 12, 5, 99};
        System.out.println(new SubsetSum().subsetSum(set,9));
    }
}
