package leetcode.easy;

import java.util.Arrays;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 思路
 * 质数的倍数都不可能是质数
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim,true);

        for (int i=2;i<=n;i++){
            if (isPrim[i]){
                for (int j=2*i;j<=n;j+=i){
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i=2;i<=n;i++){
            if (isPrim[i]) count++;
        }
        return count;
    }
}
