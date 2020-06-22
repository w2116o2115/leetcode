package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
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
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 从下往上 去相加
 *
   res[i, j] - 当前元素的最短路径
   当前元素的最短路径等于其下一层的相邻元素中的较小者与当前元素之和：
   状态转移方程：
   res[i][j] = min(res[i + 1][j], res[i + 1][j + 1]) + triangle[i][j]
 */
public class MinimumTotal$SOS {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        int column=triangle.get(row-1).size();//最后一行数最多，作为数组列数来用
        int dp[][]=new int[row][column];

        for(int i=0;i<column;i++)
            dp[row-1][i]=triangle.get(row-1).get(i);//最后一行到底部的距离就等于它自身的值
        for(int i=row-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
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
