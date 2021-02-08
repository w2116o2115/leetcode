package dynamic_programming;

/**
 * 1277. 统计全为 1 的正方形子矩阵
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 */
public class CountSquares$$retry {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int res = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j] == 0) continue;
                if (i ==0 || j ==0) {// 在边上， 直接 一个1 就是一个正方形
                    res++;
                    continue;
                }
                int min = Math.min(Math.min(matrix[i-1][j-1],matrix[i-1][j]),matrix[i][j-1]);
                matrix[i][j] += min;
                res+=matrix[i][j];
            }
        }
        return res;
    }
}