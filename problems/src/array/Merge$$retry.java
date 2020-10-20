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
 * 思路:首先去要对数据进行排序
 */
public class Merge$$retry {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (null==intervals || intervals.length == 0)
            return res.toArray(new int[0][]);
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        int index=0;
        while (index < intervals.length){
            int left = intervals[index][0];
            int right = intervals[index][1];
            while (index<intervals.length && intervals[index+1][0] <= right){
                index++;
                right = Math.max(right,intervals[index][1]);
            }
            res.add(new int[]{left,right});
            index++;
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] a = new int[2][2];
        a[0] = new  int[]{1,4};
        a[1] = new  int[]{2,3};

        System.out.println(new Merge$$retry().merge(a));
    }
}
