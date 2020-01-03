package leetcode.easy;

import java.util.Arrays;

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        for (int i = digits.length-1;i>=0;i--){
            if (i == digits.length-1 || flag) {
                if (digits[i] + 1 >= 10) {
                    flag = true;
                    digits[i] = (digits[i] + 1) % 10;
                }else {
                    digits[i] = digits[i] + 1;
                    flag = true;
                }
            }else {
                return digits;
            }
        }
        if (flag){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for (int i=1;i<digits.length;i++){
                res[i] = digits[i];
            }
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(new PlusOne().plusOne(new int[]{9}));
    }
}
