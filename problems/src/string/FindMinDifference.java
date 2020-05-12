package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 539. 最小时间差
 *
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 * 示例 1：
 *
 * 输入: ["23:59","00:00"]
 * 输出: 1
 *
 * 思路： 先把String换算成分钟，然后排序，最后减法
 */
public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<>();
        timePoints.forEach(timePoint -> {
            if(timePoint.split(":")[0].equals("00") && timePoint.split(":")[1].equals("00")){
                times.add(24*60);
            }else {
                times.add(Integer.valueOf(timePoint.split(":")[0])*60 + Integer.valueOf(timePoint.split(":")[1]));
            }
        });

        Collections.sort(times);

        int min = Integer.MAX_VALUE;
        for (int i=1;i<times.size();i++){
            min = Math.min(min,times.get(i)-times.get(i-1));
        }
        return Math.min(min,24*60+times.get(0) - times.get(times.size()-1));
    }
}