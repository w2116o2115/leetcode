package array;

/**
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 *
 * 解题思路
 * 首先保留一个cache,存放的是每个位置的字符以及下标。
 * 然后开始从头循环，对于每一个数，从'9'开始找是否存在比当前位置大的最大的数字，有则交换.
 * 时间复杂度分析:O(9*n) 空间复杂度O(n)
 */
public class MaximumSwap$retry {
    public int maximumSwap(int num) {
        int[] count = new int[10];
        char[] chs = String.valueOf(num).toCharArray();
        for(int i = 0 ; i < chs.length ; i++) {
            count[(chs[i] - '0')] = i;
        }
        for(int i = 0 ; i < chs.length ; i++) {
            int cur = (chs[i] - '0');
            int j = 9;
            for(;j > cur; j--) {
                if(count[j] > i) {
                    break;
                }
            }
            if(j != cur) {
                swap(chs, i, count[j]);
                return Integer.valueOf(String.valueOf(chs));
            }
        }
        return num;
    }

    public void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSwap$retry().maximumSwap(5432));
    }
}
