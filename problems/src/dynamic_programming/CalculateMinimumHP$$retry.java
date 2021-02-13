package dynamic_programming;

import java.util.Arrays;

/**
 * 174. 地下城游戏
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * 则骑士的初始健康点数至少为 7。
 *
     -2 (K)	-3	 3
     -5	   -10	 1
     10	   30	-5 (P)

     思路 ： 最后一步应该是1点血，反推，从右下角 往左上角走
            dp[i][j]  表示到当前的位置所需要的最小血量
 */
public class CalculateMinimumHP$$retry {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[row+1][cols+1];
        //初始化
        for (int i=0;i<=row;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);//需要去最小值，所以初始化成最大值
        }

        dp[row][cols-1] = 1; //多了一行 生命值初始化最小
        dp[row-1][cols] = 1; //多了一列 生命值初始化最小

        for (int i=row-1;i>=0;i--){
            for (int j=cols-1;j>=0;j--){
                int min = Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = min <=0?1:min;
            }
        }
        return dp[0][0];
    }
}
