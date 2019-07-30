package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gouthamvidyapradhan on 25/03/2017.
 *
 * <p>在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * <p>For example, given k = 3, Return [1,3,3,1].
 *
 * <p>Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangle$E {
  public static void main(String[] args) throws Exception {
    System.out.println(new PascalsTriangle$E().getRow(6));
  }

  public List<Integer> getRow(int rowIndex) {
    int k = rowIndex;
    if (k == 0) return new ArrayList<>(0);
    if (k == 1) return Arrays.asList(1,1);
    if (k == 2) return Arrays.asList(1,2,1);
    List<Integer> result = new ArrayList<>();
    k = k - 2;
    result.add(2);
    while (k-- > 0){
      int p = 1;
      int n = 0;
      for (int i = result.size(); i>n;n++){
        int c = result.get(n);
        result.set(n,c + p);
        p = c;
      }
      result.add(p + 1);
    }
    result.add(0,1);
    result.add(1);
    return result;
  }
}
