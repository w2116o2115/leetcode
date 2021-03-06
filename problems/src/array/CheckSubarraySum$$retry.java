package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 *
 * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * 示例 1：
 *
 * 输入：[23,2,4,6,7], k = 6
 * 输出：True
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 *
 * 典型的 ： 前缀 和 , 所有的前缀和 都要对 0 进行特殊处理
 *           (sum1 + sum2)
 */
public class CheckSubarraySum$$retry {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        for (int i=0;i< nums.length;i++){
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)){
                if (i-map.get(sum) >= 2) return true;
            }
            map.putIfAbsent(sum,i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CheckSubarraySum$$retry().checkSubarraySum(new int[]{23,2,4,6,7},6));
    }
}