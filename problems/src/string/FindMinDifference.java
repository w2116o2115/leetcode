package string;

import java.util.Arrays;
import java.util.List;

/**
 * 539. 最小时间差
 *
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 *
 *
 * 示例 1：
 *
 * 输入: ["23:59","00:01"]
 * 输出: 1
 *
 * 备注:
 *
 * 列表中时间数在 2~20000 之间。
 * 每个时间取值在 00:00~23:59 之间。
 *
 * 如果两个时间差大于 12小时 需要取反     一次for循环保证两两相减就行了
 */
public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        return bankTrack(Integer.MAX_VALUE,0,timePoints);
    }

    private int bankTrack(int min,int cur,List<String> timePoints){
        if (cur == timePoints.size())
            return min;

        String currentTIme = timePoints.get(cur);

        for (int i=cur+1;i<timePoints.size();i++){
            min = Math.min(min,getMin(currentTIme,timePoints.get(i)));
        }
        min = Math.min(min,bankTrack(min,cur+1,timePoints));

        return min;
    }

    private int getMin(String cur,String time){
        int t1 = Integer.valueOf(cur.split(":")[0])*60 + Integer.valueOf(cur.split(":")[1]);
        int t2 = Integer.valueOf(time.split(":")[0])*60 + Integer.valueOf(time.split(":")[1]);

        if (Math.abs(t1 - t2) > 12*60){
            return 24*60 - Math.abs(t1 - t2);
        }
        return Math.abs(t1 - t2);
    }

    public static void main(String[] args) {
        System.out.println(new FindMinDifference().findMinDifference(Arrays.asList("01:01","02:01","03:00")));
    }
}
