package merge;

/**
 * 779. 第K个语法符号
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 *
 * 例子:
 *
 * 输入: N = 1, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 1
 * 输出: 0
 *
 * 输入: N = 2, K = 2
 * 输出: 1
 *
 * 输入: N = 4, K = 5
 * 输出: 1
 *
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 *
 * 按照规律写出几行，可以注意到一个规律：每一行的后半部分正好是前半部分的 ”翻转“，前半部分是 '0'，后半部分变成 '1'，前半部分是 '1'，后半部分变成 '0'。
 *
 * 可以通过归纳法证明以上规律，核心的思想在于，如果 XX 可以生成 YY，那么 X'X
 * ′
 *   就能生成 Y'Y
 * ′
 *  。据此可以提出以下的算法： 如果 K 在第二部分，就找 K -= (1 << N-2) 在第一部分的答案，然后将答案翻转。
 *
 */
public class KthGrammar$$retry {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (K <= 1 << N-2)
            return kthGrammar(N-1, K);
        return kthGrammar(N-1, K - (1 << N-2)) ^ 1;
    }
}