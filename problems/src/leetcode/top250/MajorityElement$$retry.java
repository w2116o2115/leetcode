package leetcode.top250;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. 求众数 II
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 *
 * 思路： 摩尔投票法  将众数和其他数进行相抵，到最后剩下的一定是众数
 *
 * 明确一点就是众数最多只能有2个，如果两个数出现的次数分别为a和b，a>n/ 3, b>n/3，这两个数为众数，设其他数字的出现次数为c，那么a+b+c=n，有a+b>2n/3，c<n/3，因此最多只能有两个众数。
 * 我们每次移除3个不同的数，因为a和b都大于c，a-c以及b-c都大于0，最后剩下的就一定是众数。
 * 但是众数有可能是0个或者1个，因此为了确认选出来的两个数是否是众数，还要进行一次遍历确认其出现次数是否大于n/3
 *
 * 代码编写
 *      如果当前元素等于cand1，则cand1次数加1
 *      如果当前元素等于cand2，则cand2次数加1
 *      如果都不等，如果其中候选者的次数为0，则更换候选
 *      若num符合前面3个条件的其中一个，就要需要考虑下一个元素，因为如果满足了前面3个条件的其中一个num就成了候选者，如果前面3个条件都不满足，
 *          说明cand1、cand2与当前元素num各不相等，且cand1和cand2至少存在1个，那么同时移除一个cand1、cand2和num
 *      最后为了确保选出来的候选者是众数，还要一次遍历统计判断是否为众数
 *
 */
public class MajorityElement$$retry {
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0, cnt1 = 0;
        int cand2 = 0, cnt2 = 0;
        for(int num : nums){
            if(num == cand1){
                cnt1++;
                continue;
            }

            if(num == cand2){
                cnt2++;
                continue;
            }

            // 更换候选1
            if(cnt1 == 0){
                cand1 = num;
                cnt1 = 1;
                continue;
            }

            // 更换候选2
            if(cnt2 == 0){
                cand2 = num;
                cnt2 = 1;
                continue;
            }

            // 同时移除一个cand1、cand2和num
            cnt1--;
            cnt2--;
        }

        // 还需一次遍历判断候选是否为众数
        cnt1 = cnt2 = 0;
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            if(num == cand1){
                cnt1++;
            }else if(num == cand2){
                cnt2++;
            }
        }
        if(cnt1 > nums.length / 3)
            list.add(cand1);
        if(cnt2 > nums.length / 3)
            list.add(cand2);

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement$$retry().majorityElement(new int[]{1,1,1,3,3,2,2,2}));
    }
}
