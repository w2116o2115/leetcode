package leetcode.easy;

/**
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 *
 * 牛逼思路  X = 100*a + 10*b + c = 99*a + 9*b + (a+b+c)；所以对9取余即可。
 */
public class AddDigits {
    public int addDigits(int num) {
        int sum=0;
        while(num>=10)
        {
            sum=0;
            while(num>0)
            {
                int temp=num%10;
                sum+=temp;
                num/=10;
            }
            num=sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(388));
    }
}
