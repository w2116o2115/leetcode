package leetcode.easy;

/**
 * 263. 丑数
 * 编写一个程序判断给定的数是否为丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例 1:
 *
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 示例 2:
 *
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 示例 3:
 *
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 */
public class IsUgly {
    public boolean isUgly(int num) {
        int[] nums = new int[]{2, 3, 5};
        int flag = 0;
        while (num>1){
            for (int n:nums){
                if (num%n != 0) {
                    flag++;
                }else {
                    num/=n;
                }
            }
            if (flag == 3)
                return false;
            flag = 0;
        }
        return num==1;
    }

    public static void main(String[] args) {
        System.out.println(new IsUgly().isUgly(14));
    }
}
