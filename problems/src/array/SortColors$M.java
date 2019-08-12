package array;

/**
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
public class SortColors$M {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] nums = {2, 1, 0, 0, 1};
    new SortColors$M().sortColors(nums);
    for (int i : nums) System.out.println(i);
  }

  public void sortColors(int[] nums) {
    int s = nums[0]; // save the first index value
    nums[0] = 1; // overwrite with 1
    int l = 0, r = 0; // left and right index indicating the start and end index of 1s
    for (int i = 1; i < nums.length; i++) {
      switch (nums[i]) {
        case 0:
          nums[l] = 0;
          nums[r + 1] = 1;
          if (r + 1 != i) {
            nums[i] = 2;
          }
          l++;
          r++;
          break;

        case 1:
          nums[r + 1] = 1;
          if (r + 1 != i) {
            nums[i] = 2;
          }
          r++;
          break;
      }
    }
    // replace the initial overwritten value with the original value
    if (s == 0) nums[l] = 0;
    else if (s == 2) nums[r] = 2;
  }
}
