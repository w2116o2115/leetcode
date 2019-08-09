package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class SetMatrixZeroes$M {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[][] matrix = {{0, 8, 7}, {9, 0, 8}, {9, 9, 0}};

    new SetMatrixZeroes$M().setZeroes(matrix);
  }

  public void setZeroes(int[][] matrix) {
    Set<Integer> row = new HashSet<>();
    Set<Integer> col = new HashSet<>();
    int m = matrix.length;
    int n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          row.add(i);
          col.add(j);
        }
      }
    }

    for (int r : row) {
      for (int j = 0; j < n; j++) {
        matrix[r][j] = 0;
      }
    }

    for (int c : col) {
      for (int i = 0; i < m; i++) {
        matrix[i][c] = 0;
      }
    }
  }
}
