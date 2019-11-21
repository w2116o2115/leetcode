package math;

/**
 * 12 . 整数转罗马
 * @author Carlose wei
 * @version 1.0
 * @date 2019/11/20 10:30
 */
public class IntToRoman {
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};  // 罗马数字
        int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  // 阿拉伯数字
        int index = 0;
        while (num > 0){
            int count = num/arab[index];
            System.out.println("相除所得 = " + count);
            while (count --> 0){
                ans.append(roman[index]);
            }
            num %= arab[index];
            System.out.println("num = " + num);
            index++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntToRoman().intToRoman(2222));
    }
}
