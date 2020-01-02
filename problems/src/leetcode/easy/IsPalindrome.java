package leetcode.easy;

/**
 * 9. 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        int source = x;
        if (x < 0){
            return false;
        }
        int ans = 0;
        while (x!=0){
            int pop = x%10;
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && pop > 7))
                return false;
            ans = ans*10 + pop;
            x /= 10;
        }
        return ans == source;
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome(121));
    }
}
