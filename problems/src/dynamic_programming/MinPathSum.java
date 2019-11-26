package dynamic_programming;

/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        int[][] dp = new int[R][C];
        dp[0][0] = grid[0][0];
        for (int i=1;i<R;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j=1;j<C;j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i=1;i<R;i++){
            for (int j=1;j<C;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[R-1][C-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2},{5,6},{1,1}};

        System.out.println(new MinPathSum().minPathSum(grid));
    }
}
