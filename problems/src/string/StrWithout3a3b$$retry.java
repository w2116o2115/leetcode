package string;

/**
 * 984. 不含 AAA 或 BBB 的字符串
 *
 给定两个整数 A 和 B，返回任意字符串 S，要求满足：

 S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 子串 'aaa' 没有出现在 S 中；
 子串 'bbb' 没有出现在 S 中。

 示例 1：

 输入：A = 1, B = 2
 输出："abb"
 解释："abb", "bab" 和 "bba" 都是正确答案。
 */
public class StrWithout3a3b$$retry {
    public String strWithout3a3b(int a, int b) {
        char ca = 'a'; char cb = 'b';
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
            ca = 'b';
            cb = 'a';
        }

        StringBuilder str = new StringBuilder();
        while (a > 0){
            str.append(ca);
            a--;
            if (a >b){
                str.append(ca);
                a--;
            }
            if (b > 0){
                str.append(cb);
                b--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StrWithout3a3b$$retry().strWithout3a3b(1,2));
    }
}
