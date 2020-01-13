package leetcode.top250;

/**
 * 233. 数字 1 的个数
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * 示例:
 *
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 *
 * 算法  完全特么不会
 *
 * 将 ii 从 11 遍历到 nn，每次遍历 ii 扩大 1010 倍：
 * (n/(i*10))*i(n/(i∗10))∗i 表示 (i*10)(i∗10) 位上 \text{'1'}’1’ 的个数。
 * {min(max((text{n mod (i*10)} )-i+1,0),i)}min(max((n mod (i*10))−i+1,0),i) 表示需要额外数的 (i*10)(i∗10) 位上 \text{'1'}’1’ 的个数。
 */
public class CountDigitOne {
    public int countDigitOne(int n) {
        int countr = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            countr += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        return countr;
    }
}
