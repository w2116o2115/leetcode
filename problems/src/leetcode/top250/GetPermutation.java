package leetcode.top250;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 思路:
 * 这道题有个回溯标签,用回溯算法超时,回溯算法真的可以过吗?
 *
 * 我感觉这道题就是个找规律题目!
 *
 * 直接举例子:
 *
 * 比如n = 3, k = 3
 *
 * 我们要由num = [1, 2, 3]这三个数组成!
 *
 * 首先我们要确定首位置是什么?我们整体看一下所有数;
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 我们发现当首数字确定了,后面和首数字组成数字的个数相等的!
 *
 * 比如: 首数字为1,后面有组成两个数123,132,可以组成2个数.当首数字为2,3同样都是.
 *
 * 所有我们要找k = 3的数字 ,我们只需要 3/2 便可找到首数字什么,
 *
 * 下面依次类推!
 *
 * 其实就是一道找规律题目!
 *
 * 代码大同小异, 逻辑都是一样的! 大家可以自己动手写,如有更好的写法分享一下!哈哈!
 *
 */
public class GetPermutation {
    public String getPermutation(int n, int k) {
        /**
         直接用回溯法做的话需要在回溯到第k个排列时终止就不会超时了, 但是效率依旧感人
         可以用数学的方法来解, 因为数字都是从1开始的连续自然数, 排列出现的次序可以推
         算出来, 对于n=4, k=15 找到k=15排列的过程:

         1 + 对2,3,4的全排列 (3!个)
         2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
         3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
         4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)

         确定第一位:
         k = 14(从0开始计数)
         index = k / (n-1)! = 2, 说明第15个数的第一位是3
         更新k
         k = k - index*(n-1)! = 2
         确定第二位:
         k = 2
         index = k / (n-2)! = 1, 说明第15个数的第二位是2
         更新k
         k = k - index*(n-2)! = 0
         确定第三位:
         k = 0
         index = k / (n-3)! = 0, 说明第15个数的第三位是1
         更新k
         k = k - index*(n-3)! = 0
         确定第四位:
         k = 0
         index = k / (n-4)! = 0, 说明第15个数的第四位是4
         最终确定n=4时第15个数为3214
         **/

        StringBuilder sb = new StringBuilder();
        // 候选数字
        List<Integer> candidates = new ArrayList<>();
        // 分母的阶乘数
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        int fact = 1;
        for(int i = 1; i <= n; ++i) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for(int i = n-1; i >= 0; --i) {
            // 计算候选数字的index
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            k -= index*factorials[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new GetPermutation().getPermutation(3,3));
    }
}
