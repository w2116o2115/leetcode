package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的z`的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class SubarraySum {
//    public int subarraySum(int[] nums, int k) {
//        int size = nums.length, res = 0;
//        for (int i = 0; i < size; ++i) {
//            int sum = 0;
//            for (int j = i; j < size; ++j) {
//                sum += nums[j];
//                res += sum == k ? 1 : 0;
//            }
//        }
//        return res;
//    }

    /**
     * 思想 sum1  sum2 之间的差是k 说明这个两个和之间的子集和未K
     * 把所有的sum放入map中，key sum  value sum的次数
     */
    public int subarraySum(int[] nums, int k) {
        int sum = 0;int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int num:nums){
            sum+=num;
            if (map.containsKey(sum-k)){
                res+=map.get(num-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySum().subarraySum(new int[]{1,2,1,2,1},3));
    }
}
