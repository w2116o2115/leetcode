package array;

/**
 * Created by gouthamvidyapradhan on 04/07/2017. Given an array containing n distinct numbers taken
 * from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * <p>For example, Given nums = [0, 1, 3] return 2.
 *
 * <p>Note: Your algorithm should run in linear runtime complexity. Could you implement it using
 * only constant extra space complexity?
 *
 * 通过观察，我们可以发现，nums中的元素组成是一个以1为等差的等差数列，我们可以通过等差数列的和来找出缺失的元素，其求和公式为：
 *
 * Sum = n*(A1+An)/2
 * 题目中的数组是从0开始到n，即A1=0，An=n-1，我们计算的时候可以从1到数组长度，即A1=1，An=n，然后对其求和，
 * 借助for循环，此处有两种方式，一是用和去减每一个元素，最后剩下的就是缺失的元素；二是算出数组所有元素的和，
 * 再算等差数列的和与其的差值，就是缺失的元素。
 */
public class MissingNumber$E {

  public static void main(String[] args) throws Exception {
    int[] nums = {0};
    System.out.println(new MissingNumber$E().missingNumber(nums));
  }

  public int missingNumber(int[] nums) {
    int sum = 0;
    int n = nums.length;
    for (int num : nums) {
      sum += num;
    }
    int arrSum = (((n + 1)) * n) / 2;
    if (arrSum == sum) return 0;
    else return arrSum - sum;
  }
}
