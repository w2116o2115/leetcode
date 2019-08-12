package array;

/**
 * 稀疏矩阵相乘
 *
 * <p>Example:
 *
 * <p>A = [ [ 1, 0, 0], [-1, 0, 3] ]
 *
 * <p>B = [ [ 7, 0, 0 ], [ 0, 0, 0 ], [ 0, 0, 1 ] ]
 *
 * <p>| 1 0 0 | | 7 0 0 | | 7 0 0 | AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 | | 0 0 1 |
 *
 * <p>Solution: Skip the rows and columns which you already know would result in zero after
 * multiplication.
 *
 * 稀疏矩阵 就是 大所属元素都是0的矩阵
 * 矩阵乘法  ： 用A的第1行各个数与B的第1列各个数对应相乘后加起来,就是乘法结果中第1行第1列的数；
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 */
public class SparseMatrixMultiplication$M {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[][] A = {{1, 0, 0, 1}};
    int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}, {0, 0, 1}};
    int[][] C = new SparseMatrixMultiplication$M().multiply(A, B);
  }

  public int[][] multiply(int[][] A, int[][] B) {
    int m = A.length;
    int n = A[0].length;
    int bn = B[0].length;
    int[][] C = new int[m][bn];
    for (int i=0;i<m;i++){
      for (int k=0;k<n;k++){
        if (A[i][k] == 0) continue;
        for (int j=0;j<bn;j++){
          C[i][j] *= A[i][k] * B[k][j];
        }
      }
    }
    return C;
  }
}
