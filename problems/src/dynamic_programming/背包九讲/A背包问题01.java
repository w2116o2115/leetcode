package dynamic_programming.背包九讲;

import java.util.Scanner;

/**
 *  * 二维动态规划
 *  * dp[i][j]  只看前i个物品，总体积是j的情况下总价值最大是多少
 *  * result = max(dp[0][0-V])
 *  *
 *  不选第i个物品  dp[i][j] = dp[i-1][j]
 *  选第i个物品    dp[i][j] = dp[i-1][j-v[i]] + w[i]
 *  dp[i][j] = max(1,2)
 *
 *  初始化
 *  dp[0][0] = 0; 一个物品不选
 *
 *  https://www.cnblogs.com/jbelial/articles/2116074.html
 */
public class A背包问题01 {
    static int[] w = new int[6];
    static int[] v = new int[6];
    public static void solution(){
        int[][] temp = new int[6][9];//6 是物品   9 是体积
        for(int j = 0;j < 9;j++){
            temp[0][j] = 0;
        }
        for(int i = 1;i < 6;i++){
            temp[i][0] = 0;
        }

        for(int i = 1;i < 6;i++){
            for(int j = 1;j < 9;j++){
                if(w[i] <= j){
                    temp[i][j] = Math.max(temp[i-1][j], temp[i-1][j-w[i]]+v[i]);
                }else{
                    temp[i][j] = temp[i-1][j];
                }
            }
        }

        /*
            for i=1..N
            for v=V..0
            f[v]=max{f[v],f[v-c[i]]+w[i]};
         */
        int[] dp = new int[9];
        for (int i=0;i<6;i++){
            for (int j=9;j>=0;j--){
                dp[j] = Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }

        for(int i = 0;i < 6;i++){
            for(int j = 0;j < 9;j++){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("请依次输入重量和价值:");
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            w[i] = scn.nextInt();//输入重量
            v[i] = scn.nextInt();//输入价值
        }
        solution();
    }
}