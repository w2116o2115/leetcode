package array;

import java.math.BigInteger;
import java.util.*;

/**
 * 给定非负整数X的数组形式A，返回整数X + K的数组形式。例如：
 *
 * 输入：A = [1,2,0,0]，K = 34
 * 输出：[1,2,3,4]
 * 说明：1200 + 34 = 1234
 *
 * 输入：A = [2,7,4]，K = 181
 * 输出：[4,5,5]
 * 说明：274 + 181 = 455
 *
 * 输入：A = [2,1,5]，K = 806
 * 输出：[1,0,2,1]
 * 说明：215 + 806 = 1021
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9]，K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 说明：9999999999 + 1 = 10000000000
 */
public class AddToArrayFormOfInteger$E {
  public static void main(String[] args) {
    int[] A = new int[]{9,9,9,9,9,9,9,9,9,9};
    List<Integer> list = addToArrayForm(A,1);
    for (int a:list){
      System.out.println(a);
    }
  }

  private static List<Integer> addToArrayForm(int[] A, int K) {
    StringBuilder sb = new StringBuilder();
    for (int a:A){
      sb.append(a);
    }
    BigInteger bigInteger = new BigInteger(sb.toString());
    BigInteger result =bigInteger.add(BigInteger.valueOf(K));
    String resultStr = result.toString();
    List<Integer> list = new ArrayList<>();
    for (char c : resultStr.toCharArray()){
      list.add(Integer.parseInt(String.valueOf(c)));
    }
    return list;
  }
}
