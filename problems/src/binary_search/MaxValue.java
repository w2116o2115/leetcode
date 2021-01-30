package binary_search;

import java.util.*;

/**
 * 找出最大收益的 买卖时机
 * @author carlos zhang
 * @date 2021/1/30 下午1:38
 */
public class MaxValue {
    private int[] getMax(int[] prices){
        int max = 0;
        for (int i:prices){
            max = Math.max(max,i);
        }
        int[] temp = new int[max+1];
        Arrays.fill(temp,-1);
        for (int i=0;i<prices.length;i++){
            if (temp[prices[i]] == -1) temp[prices[i]] = i;
        }
        int left = 0;
        int right = max;
        while (temp[left] == -1 || temp[left] > temp[right]){
            left++;
        }
        return new int[]{temp[left],temp[right]};
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,3,4,7,2,1,7};
        int[] res = new MaxValue().getMax(prices);
        System.out.println(1);
    }
}
