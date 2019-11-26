package dynamic_programming;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2019/11/26 11:07
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 1; i < R; i++) {
            dp[i][0] = (dp[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            dp[0][i] = (dp[0][i] == 0 && dp[0][i - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[R - 1][C - 1];
    }

    public static void main(String[] args) {
    }
}
