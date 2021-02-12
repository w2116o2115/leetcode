package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1054. 距离相等的条形码
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 示例 1：

 输入：[1,1,1,2,2,2]
 输出：[2,1,2,1,2,1]

 思路 ：用堆去解
 */
public class RearrangeBarcodes$$retry {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int b : barcodes){
            map.put(b,map.getOrDefault(b,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        int index = 0;
        int[] res = new int[barcodes.length];
        while (!maxHeap.isEmpty()){
            int a = maxHeap.poll();
            res[index++] = a;
            if (maxHeap.size() == 0) break;
            int b = maxHeap.poll();
            res[index++] = b;
            update(map,maxHeap,a);
            update(map,maxHeap,b);
        }
        return res;
    }

    private void update(Map<Integer, Integer> map, PriorityQueue<Integer> maxHeap, int a) {
        if (map.get(a) == 1){
            map.remove(a);
        }else {
            map.put(a,map.get(a)-1);
            maxHeap.offer(a);
        }
    }
}
