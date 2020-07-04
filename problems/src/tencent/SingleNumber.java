package tencent;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 说明：

 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:

 输入: [2,2,1]
 输出: 1
 示例 2:

 输入: [4,1,2,1,2]
 输出: 4

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/single-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        quickOrder(0,nums.length-1,nums);
        for (int i = 0;i<nums.length;i++){
            if (i+1 < nums.length){
               if (nums[i] != nums[i+1]){
                   return nums[i];
               }
               i++;
            }
        }
        return nums[nums.length-1];
    }
    
    public void quickOrder(int i,int j,int[] nums){
        if (i > j) return;
        int left = i;
        int right = j;
        int sentry = nums[left];
        if (left < right){
            while (left < right && nums[right] >= sentry){
                right--;
            }
            while (left < right && nums[left] <= sentry){
                left++;
            }
            if (left < right){
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
            }
        }

        nums[i] = nums[left];
        nums[left] = sentry;
        quickOrder(i,left-1,nums);
        quickOrder(left+1,j,nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        System.out.println(new SingleNumber().singleNumber(nums));
    }
}
