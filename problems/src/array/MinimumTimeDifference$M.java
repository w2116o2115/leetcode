package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 最小时间差
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 *
 * 示例 1：
 *
 * 输入: ["23:59","00:00"]
 * 输出: 1
 *
 * 备注:
 *
 * 列表中时间数在 2~20000 之间。
 * 每个时间取值在 00:00~23:59 之间。
 */
public class MinimumTimeDifference$M {
    public static int findMinDifference(List<String> timePoints) {
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

    public static void main(String[] args) {
        String[] times = new String[]{"05:31","22:08","00:35"};
        System.out.println(findMinDifference(Arrays.asList(times)));
    }
}
