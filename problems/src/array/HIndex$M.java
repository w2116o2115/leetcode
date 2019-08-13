package array;

import java.util.Arrays;

/**
 * h偏论文被引用了至少h次
 * {3, 0, 6, 1, 5} 其中3偏论文至少被引用了 3次
 * 先排序 下标 + 1 = 本身
 */
public class HIndex$M {

  public static void main(String[] args) throws Exception {
    int[] A = {3, 0, 6, 1, 5};
    System.out.println(new HIndex$M().hIndex(A));
  }

  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    for (int i=citations.length-1;i>0;i--){
      if (i+1 == citations[i])
        return i+ 1;
    }
    return -1;
  }
}
