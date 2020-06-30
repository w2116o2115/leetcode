package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class MinimumTotal$SOS {
    public int minimumTotal(List<List<Integer>> triangle) {
        int r = triangle.size();
        int c = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[r][c];
        for (int i=0;i<c;i++){
            dp[r-1][i] = triangle.get(r-1).get(i);
        }
        for (int i=r-2;i>=0;i--){
            for (int j=0;j<triangle.get(i).size();j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> a = Arrays.asList(2);
        List<Integer> a1 = Arrays.asList(3,4);
        List<Integer> a2 = Arrays.asList(6,5,7);
        List<Integer> a3 = Arrays.asList(4,1,8,3);
        triangle.add(a);
        triangle.add(a1);
        triangle.add(a2);
        triangle.add(a3);

        System.out.println(new MinimumTotal$SOS().minimumTotal(triangle));
    }
}