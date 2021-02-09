package depth_first_search;

import java.util.PriorityQueue;

/**
 * 787. K 站中转内最便宜的航班
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 *
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 *
 * 思路 ： 用堆来解决，
 */
public class FindCheapestPrice$$retry {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] g = new int[n][n];// 用来记录  从 a -- > b 所用的金钱
        for (int[] flight:flights){
            g[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]); //小顶堆 用来存放钱最少的飞行路线
        heap.offer(new int[]{0,src,K+1}); // 花费的钱   所在的地点   还剩的中转次数

        while (!heap.isEmpty()){
            int[] cur = heap.poll();
            int price = cur[0],place = cur[1],remainStops = cur[2];
            if (place == dst) return price;
            if (remainStops > 0){
                for (int i = 0;i<n;i++){
                    if (g[place][i] > 0) { //如果可以飞
                        heap.offer(new int[]{price + g[place][i], i, remainStops - 1});
                    }
                }
            }
        }
        return -1;
    }
}