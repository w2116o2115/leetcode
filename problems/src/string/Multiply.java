package string;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        String rest = "1";

        while (num1.length()>0){
            String x = num1.substring(0,1);
            String mult = mult(x,num2,num1.length()-1);
            rest = add(rest,mult);
            num1 = num1.substring(1);
        }
        return rest;
    }

    private String mult(String x,String num2,int zero){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i=num2.length()-1;i>=0;i--){
            System.out.println(num2.charAt(num2.length()-1-i));
            int xx = Integer.parseInt(x);
            int yy = num2.charAt(i) - '0';
            int sum = (xx*yy + carry) % 10;
            sb.append(sum);
            carry = (xx*yy + carry) / 10;
        }
        sb = sb.reverse();
        while (zero-->0){
            sb.append("0");
        }
        return sb.toString();
    }

    private String add(String num1,String num2){
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Multiply().multiply("123","456"));
    }
}