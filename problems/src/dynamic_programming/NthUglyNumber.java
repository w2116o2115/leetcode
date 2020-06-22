package dynamic_programming;

/**
 * 264. 丑数 II
 *
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12  15是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * 因为丑数是2, 3, 5的倍数   用三指针
 * 思路：动态规划思想。后面的丑数一定是由前面的丑数乘以2、3或5得到
 *  所以第n个丑数一定是由前n-1个数中的某3个丑数（分别记为index2、index3、index5）分别乘以2、3或者5得到的数中的最小数，
 *  index2，index3，index5有个特点，即分别乘以2、3、5得到的数一定含有比第n-1个丑数大（可利用反证法：否则第n-1个丑数
 *  就是它们当中的一个）最小丑数，即第n个丑数由u[index2]*2、u[index3]*3、u[index5]*5中的最小数得出
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2=0,i3=0,i5=0;
        for (int i=1;i<n;i++){
            int min = Math.min(i2*2,Math.min(i3*3,i5*5));
            if (i2*2 == min) i2++;
            if (i3*3 == min) i3++;
            if (i5*5 == min) i5++;
            dp[i] = min;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber().nthUglyNumber(11));
    }
}
