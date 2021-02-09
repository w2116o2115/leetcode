package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * 示例：
 *
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 *
 * 思路： 分制 mergeSort
 */
public class CountSmaller$$retry {

    class Item{
        int val;
        int index;

        public Item(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Item[] items = new Item[n];
        for (int i=0;i<nums.length;i++){
            items[i] = new Item(nums[i],i);
        }

        int[] count = new int[n];
        mergeSort(items,0,n-1,count);
        List<Integer> res = new ArrayList<>();
        for (int c:count){
            res.add(c);
        }
        return res;
    }

    private void mergeSort(Item[] items, int lo, int lh, int[] count) {
        if (lo >= lh) return;
        int mid = (lo+lh) >> 1;
        mergeSort(items,lo,mid,count);
        mergeSort(items,mid+1,lh,count);
        merge(items,lo,mid,mid+1,lh,count);
    }

    private void merge(Item[] items, int lo, int loend, int hi, int hiend, int[] count) {
        int m = hiend - lo + 1;
        Item[] sorted = new Item[m];
        int loPtr = lo,hiPtr = hi;
        int rightCount = 0;
        int index = 0;
        while (loPtr <= loend && hiPtr <= hiend){
            if (items[hiPtr].val < items[loPtr].val){
                rightCount++;
                sorted[index++] = items[hiPtr++];
            }else {
                count[items[loPtr].index] += rightCount;
                sorted[index++] = items[loPtr++];
            }
        }

        while (loPtr <= loend){
            count[items[loPtr].index] += rightCount;
            sorted[index++] = items[loPtr++];
        }

        while (hiPtr <= hiend){
            sorted[index++] = items[hiPtr++];
        }
        System.arraycopy(sorted,0,items,lo,m);
    }
}