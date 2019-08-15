package array;

/**
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 *
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 *
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 * 注意:
 *
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
 * 数组 A 的长度范围在[1, 50000]。
 */
public class SubArraysWithBoundedMaximum$m {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] A = {2, 1, 4, 3};
    System.out.println(new SubArraysWithBoundedMaximum$m().numSubarrayBoundedMax(A, 2, 3));
  }

  public int numSubarrayBoundedMax(int[] A, int L, int R) {
    int[] DP = new int[A.length];
    int v = -1;
    for (int i = A.length - 1; i >= 0; i--) {
      if (A[i] >= L && A[i] <= R) {
        if (v != -1) {
          DP[i] = v - i + 1;
        } else {
          DP[i] = 1;
          v = i;
        }
      } else if (A[i] < L) {
        if (v == -1) {
          v = i;
        }
        if (i + 1 < A.length) {
          if (A[i + 1] < L || (A[i + 1] >= L && A[i + 1] <= R)) {
            DP[i] = DP[i + 1];
          } else {
            DP[i] = 0;
          }
        }
      } else {
        v = -1;
      }
    }
    int sum = 0;
    for (int i = 0; i < DP.length; i++) {
      sum += DP[i];
    }
    return sum;
  }
}
