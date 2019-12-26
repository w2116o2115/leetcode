package dynamic_programming.zeroOrOneknapsack;

/**
 * 子集和问题
 *
 * 已知一个非负整数集，与sum的值，确定这个集合是否存在这样的子集，这个子集所有元素和等于sum。
 *
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class SubsetSum {
    public boolean subsetSum(int[] nums,int sum){
        int size = nums.length;
        boolean[][] dp = new boolean[size][sum+1];
        for (int i=0;i<size;i++){
            dp[0][i] = true;
        }
        for (int i=1;i<size;i++){
            for (int j=0;j<sum+1;j++){
                dp[i][j] = dp[i-1][j];
                if (j>=nums[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][sum];
    }

    public static void main(String[] args) {
        int[] set = new int[]{3, 34, 4, 12, 5, 2};
        System.out.println(new SubsetSum().subsetSum(set,9));
    }
}
