package array;

import java.util.ArrayList;
import java.util.List;

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
 * 这题我们的想法肯定是，尽量交换前面的大数位，并且和它交换的数还得是在它后面大于它的最大数
 *
 * 倒序使用数组存储下来每个位置，在它及它以后的最大数的索引
 * 然后再正序从一个数开始遍历，如果它及它以后的最大数不是它本身，那么这个数就是我们需要交换的。
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] c = String.valueOf(num).toCharArray();
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        int[] array = new int[c.length];
        array[c.length-1] = c.length-1;

        for (int i=c.length-1;i>=0;i--){
            if (c[i] - '0' > max){
                max = c[i] = '0';
                max_index = i;
            }
            array[i] = max_index;
        }

        for (int i=0;i<c.length;i++){
            if (array[i] != i && c[array[i]] != c[i]){
                char tmp = c[i];
                c[i] = c[array[i]];
                c[array[i]] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(c));
    }
}
