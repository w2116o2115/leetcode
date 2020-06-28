package dynamic_programming.背包九讲;

/**
 * 题目
 * 有N种物品和一个容量为V的背包。第i种物品最多有n[i]件可用，每件费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 */
public class C多重背包问题 {
    public static int manyPack(int V, int N, int[] weight, int[] value, int[] num) {
        //初始化动态规划数组
        int[][] dp = new int[N + 1][V + 1];
        //将dp[0][j] dp[i][0]设置为0
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (j >= weight[i]) {
                    //考虑物品的件数限制
                    int max = Math.min(num[i], j / weight[i]);
                    for (int k = 0; k <= max; k++)
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * weight[i]] + k * value[i]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        int maxValue = dp[N][V];
        System.out.println(maxValue);
        int j = V;
        String numStr = "";

        for (int i = N; i > 0; i--) {
            int limit = Math.min(num[i], j / weight[i]);
            if (dp[i][j] > dp[i - 1][j]) {
                int k = limit;
                for (k = limit; k > 0; k--) {
                    numStr = i + " " + numStr;
                }
                j = j - limit * weight[i];
            }
            if (j == 0)
                break;
        }
        //打印dp[][]，可以看到最大值就是dp[N][V]
        for (int i = 0; i <= N; i++) {
            for (int K = 0; K <= V; K++) {
                System.out.printf("%-5d", dp[i][K]);
            }
            System.out.println();
        }
        System.out.println(numStr);
        return dp[N][V];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] weight = {0, 1, 2, 3};
        int[] value = {0, 6, 13, 20};
        int[] num = {0, 5, 3, 2};
        int bagV = 15;
        int N = 3;
        int result = manyPack(bagV, N, weight, value, num);
        System.out.println("result=" + result);
    }
}