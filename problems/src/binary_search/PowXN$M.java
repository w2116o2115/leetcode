package binary_search;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 直观想法
 *
 *
 */
public class PowXN$M {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(1 / new PowXN$M().myPow(2.00000, -2147483648));
  }

  public double myPow(double x, int n) {
    if (n == 0) return 1D;
    long N = n; // use long to avoid overflow.
    return solve(n < 0 ? (1 / x) : x, N < 0 ? (N * -1) : N);
  }

  public double solve(double x, long n) {
    if (n == 1) return x;
    double val = solve(x, n / 2);
    return val * val * ((n % 2) == 0 ? 1 : x); //n 分奇数和偶数   如果是奇数 需要再乘一个X
  }
}
