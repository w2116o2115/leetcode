package leetcode.top250;

/**
 * 50. Pow(x, n)
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
 * 二分法
 */
public class MyPow {
    public double myPow(double x, int n) {
        double res = fastPow(x,n);
        int y = Math.abs(n);
        return n > 0?res:(1/res);
    }

    private double fastPow(double x,long n){
        if (n == 0){
            return 1;
        }else if ((n&1) == 1){
            return fastPow(x,n-1)*x;
        }else {
            double res = fastPow(x,n/2);
            return res*res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2.00000,2));
    }
}
