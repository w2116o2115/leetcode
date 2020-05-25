package partition;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 * PriorityQueue 一个基于优先级的无界优先级队列。
 */
public class SmallestK$$SOS {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        for (int num : arr)
            heap.offer(num);
        int[] res = new int[k];
        int idx = 0;
        while (idx < k)
            res[idx++] = heap.poll();
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,2,4,6,8};
        System.out.println(Arrays.toString(new SmallestK$$SOS().smallestK(arr,4)));
    }
}