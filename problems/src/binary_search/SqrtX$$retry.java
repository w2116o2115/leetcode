package binary_search;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * 思路分析：使用二分法搜索平方根的思想很简单，就类似于小时候我们看的电视节目中的“猜价格”游戏，高了就往低了猜，低了就往高了猜，范围越来越小。因此，使用二分法猜算术平方根就很自然。
 *
 * 一个数的平方根肯定不会超过它自己，不过直觉还告诉我们，一个数的平方根最多不会超过它的一半，例如 8 的平方根，8 的一半是 4，4^2=16>8
 *
 * 如果这个数越大越是如此，因此我们要计算一下，这个边界是多少。为此，解如下不等式：
 * (a/2)^ 2 >= a
 *
 * 意即：如果一个数的一半的平方大于它自己，那么这个数的取值范围。解以上不等式得 a ≥4 或者 a≤0。
 *
 * 于是边界值就是 4，那么对 0、1、2、3 分别计算结果，很容易知道，这 4 个数的平方根依次是 0、1、1、1。
 */
public class SqrtX$$retry {
  public static void main(String[] args) throws Exception {
    System.out.println(new SqrtX$$retry().mySqrt(8));
  }

  public int mySqrt(int x) {
    long left = 0;
    // # 为了照顾到 1 把右边界设置为 x // 2 + 1
    long right = x / 2 + 1;
    while (left < right) {
      // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
      // long top250 = left + (right - left + 1) / 2;
      long mid = (left + right + 1) / 2;
      long square = mid * mid;
      if (square > x) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    // 因为一定存在，因此无需后处理
    return (int) left;
  }
}
