package math;

import java.math.BigInteger;

/**
 * 字符串转换整数 (atoi)
 * @author Carlose wei
 * @version 1.0
 * @date 2019/11/27 10:07
 */
public class MyAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) return 0;

        // + - 号
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }

    public static void main(String[] args) {
        String a = "3.14159";
        System.out.println(new MyAtoi().myAtoi(a));
    }
}
