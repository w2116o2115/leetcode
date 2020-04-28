package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 思路首先去要对数据进行排序
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        int i=0;
        while (i<intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i<intervals.length && intervals[i+1][0] <= right){
                i++;
                right = Math.max(right,intervals[i][1]);
            }
            res.add(new int[]{left,right});
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] a = new int[2][2];
        a[0] = new  int[]{1,4};
        a[1] = new  int[]{2,3};

        System.out.println(new Merge().merge(a));
    }
}
