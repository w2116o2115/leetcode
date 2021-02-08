package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2021/2/8 16:44
 * 典型的 ： 前缀 和 , 所有的前缀和 都要对 0 进行特殊处理
 *           (sum1 + sum2)
 */
public class CheckSubarraySum {
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
}