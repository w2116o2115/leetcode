package array;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]

 */
public class SortColors$$retry {
    public void sortColors(int[] nums) {
        quickSort(0,nums.length-1,nums);
    }

    private void quickSort(int l,int r,int[] nums){
        if (nums == null || nums.length <= 1) {
            return;
        }
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = p0; i <= p2; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0++] = 0;
            } else if (nums[i] == 2) {
                nums[i--] = nums[p2];
                nums[p2--] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,2,1};
        new SortColors$$retry().sortColors(nums);
        System.out.println(1);
    }
}