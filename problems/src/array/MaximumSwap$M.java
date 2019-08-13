package array;

import java.util.Arrays;

/**
 * 最大交换
 *
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
 * char 和 int 可以直接比较 比较的asc码
 */
public class MaximumSwap$M {

  public static void main(String[] args) throws Exception {
    System.out.println(new MaximumSwap$M().maximumSwap(98368));
  }

  public int maximumSwap(int num) {
    char[] D = String.valueOf(num).toCharArray();
    for (int i = 0;i<D.length-1;i++){
      int max = Integer.MIN_VALUE;
      int maxIndex = 0;
      for (int j = i+1;j<D.length;j++){
        if (max <= D[j])
          maxIndex = j;
        max = Math.max(max,D[j]);
      }
      if (D[i] < max){
        char temp = D[maxIndex];
        D[maxIndex] = D[i];
        D[i] = temp;
        return Integer.parseInt(String.valueOf(D));
      }
    }
    return Integer.parseInt(String.valueOf(D));
  }
}
