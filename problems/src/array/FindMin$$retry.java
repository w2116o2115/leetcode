package array;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 *
 *  * 当nums[mid] > nums[right]说明在mid左半边的递增区域, 说明最小元素在> mid区域
 *  *
 *  * 当nums[mid] <= nums[right说明在mid右半边的递增区域, 说明最小元素在<= mid区域
 */
public class FindMin$$retry {
    public int findMin(int[] nums) {
        return findMinHelper(nums,0,nums.length-1);
    }

    public int findMinHelper(int[] nums,int start,int end){
        if (start == end) return nums[start];
        int min = (start + end) >> 1;
        if (nums[min] > nums[end]){
            return findMinHelper(nums,min+1,end);
        }else {
            return findMinHelper(nums,start,min);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(new FindMin$$retry().findMin(nums));
    }
}