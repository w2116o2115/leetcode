package array;

import java.util.*;

/**
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
 */
public class MergeIntervals$M {
  public static class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

  public static void main(String[] args) throws Exception {
    Interval i1 = new Interval(1, 2);
    Interval i2 = new Interval(3, 4);
    Interval i3 = new Interval(5, 6);
    Interval i4 = new Interval(1, 10);
    List<Interval> result = new MergeIntervals$M().merge(Arrays.asList(i1, i2, i3, i4));
    result.forEach((I) -> System.out.println(I.start + " " + I.end));
  }

  public List<Interval> merge(List<Interval> intervals) {
    if (intervals.isEmpty()) return new ArrayList<>(0);
    List<Interval> result = new ArrayList<>();
    intervals.sort(Comparator.comparingInt(o -> o.start));
    Interval curr = intervals.get(0);
    for (int i = 1;i < intervals.size() ; i++){
      Interval interval = intervals.get(i);
      if (interval.start >= curr.start && interval.start <= curr.end) {
        curr.end = curr.end > interval.end ? curr.end : interval.end;
      }else {
        result.add(curr);
        curr = interval;
      }
    }
    result.add(curr);
    return result;
  }
}
