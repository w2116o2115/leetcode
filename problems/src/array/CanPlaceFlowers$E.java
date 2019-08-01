package array;

/**
 * Created by gouthamvidyapradhan on 10/06/2017. Accepted
 *
 * <p>Suppose you have a long flowerbed in which some of the plots are planted and some are not.
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both
 * would die.
 *
 * <p>Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means
 * not empty), and a number n, return if n new flowers can be planted in it without violating the
 * no-adjacent-flowers rule.
 *
 * <p>Example 1: Input: flowerbed = [1,0,0,0,1], n = 1 Output: True Example 2: Input: flowerbed =
 * [1,0,0,0,1], n = 2 Output: False Note: The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000]. n is a non-negative integer which won't
 * exceed the input array size.
 * 这道题给了我们一个01数组，其中1表示已经放了花，0表示可以放花的位置，但是有个限制条件是不能有相邻的花。
 *
 *
 * 要想种花，即当前地块是可以种植的（值为0），需要满足两个条件：当前地块的前一个地块是可以种植的（值也为0），
 * 当前地块的后一个地块也是可以种植的（值也为0），把满足这些条件的地块数加起来，判断与给定的花数量的大小，
 * 来返回true或者false。在这里，我们使用三个布尔值来判断，第二个布尔值与第三个布尔值表示了刚刚分析的两种情况，
 * 第一个布尔值是初始条件，只有三者都满足，那么我们就可以在当前位置种花。
 */
public class CanPlaceFlowers$E {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] n = {1, 0, 0, 0, 1};
    System.out.println(new CanPlaceFlowers$E().canPlaceFlowers(n, 2));
  }

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int i = 0;
    int len = flowerbed.length;
    while (i < len){
      //当前地块是否可以种花  必须满足前一个可以种花 后一个可以种花  当前还必须是空的
      boolean b = flowerbed[i] == 0;
      boolean b1 = i == 0 || flowerbed[i-1] == 0;
      boolean b2 = i == len -1|| flowerbed[i+1] == 0;
      if (b && b1 && b2){
        flowerbed[i] = 1;
        n--;
      }
      i++;
    }
    return n<=0;
  }
}
