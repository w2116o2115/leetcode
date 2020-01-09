package leetcode.easy;

/**
 * 342. 4的幂
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num < 0) return false;
        double temp=0;
        int i = 1;
        while (temp<=num){
            if (num == temp)
                return true;
            temp = Math.pow(4,i++);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsPowerOfFour().isPowerOfFour(-64));
    }
}
