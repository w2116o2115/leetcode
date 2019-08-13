package array;

/**
 * 最大交换
 *
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 */
public class MaximumSwap$M {

  public static void main(String[] args) throws Exception {
    System.out.println(new MaximumSwap$M().maximumSwap(2736));
  }

  public int maximumSwap(int num) {
    int[] D = new int[10];
    char[] A = String.valueOf(num).toCharArray();
    for (int i = 0; i < A.length; i++) {
      D[A[i] - '0'] = i;
    }

    boolean found = false;

    for (int i = 0; i < A.length; i++) {
      int digit = A[i] - '0';
      for (int j = 9; j > digit; j--) {
        if (D[j] > i) {
          char temp = A[i];
          A[i] = (char) (j + '0');
          A[D[j]] = temp;
          found = true;
          break;
        }
      }
      if (found) break;
    }

    return Integer.parseInt(String.valueOf(A));
  }
}
