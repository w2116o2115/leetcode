package top100;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 示例 2:

 输入: nums = [1], k = 1
 输出: [1]
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // key为值 value为出现次数
        HashMap<Integer,Integer> map = new HashMap();
        // 统计每个数出现的次数
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // list数组中每一个位置为这个数出现的次数 值为出现次数这么多的数
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 出现的次数
            int i = map.get(key);
            if(list[i]==null) list[i] = new ArrayList();
            // 当前次数中 包含那些数
            list[i].add(key);
        }
        for(int i=list.length-1;i>=0 && res.size()<k;i--){
            if(list[i]==null) continue;
            // 该题没有出现频率相同的数字 不需要考虑其他情况
            res.addAll(list[i]);
        }
        return res;

    }
}
