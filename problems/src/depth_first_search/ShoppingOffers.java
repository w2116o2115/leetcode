package depth_first_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 638. 大礼包
 *
 * 在LeetCode商店中， 有许多在售的物品。
 *
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 *
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 *
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 *
 * 任意大礼包可无限次购买。
 *
 * 示例 1:
 *
 * 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * 输出: 14
 * 解释:
 * 有A和B两种物品，价格分别为¥2和¥5。
 * 大礼包1，你可以以¥5的价格购买3A和0B。
 * 大礼包2， 你可以以¥10的价格购买1A和2B。
 * 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。
 * 示例 2:
 *
 * 输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 * 输出: 11
 * 解释:
 * A，B，C的价格分别为¥2，¥3，¥4.
 * 你可以用¥4购买1A和1B，也可以用¥9购买2A，2B和1C。
 * 你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
 * 你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
 */
public class ShoppingOffers {
    public static int minPrice = Integer.MAX_VALUE;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        for (List<Integer> sp : special){
            List<Integer> newNeed = new ArrayList<>(needs);
            dsf(0,sp,newNeed,special,price);
        }
        return minPrice;
    }

    private void dsf(int result,List<Integer> special,List<Integer> needs,List<List<Integer>> specials,List<Integer> price){
        for (int i=0;i<needs.size();i++){
            if (needs.get(i) - special.get(i) < 0){
                for (int j=0;j<needs.size();j++)
                    result += needs.get(j)*price.get(j);
                minPrice = Math.min(result,minPrice);
                return;
            }
        }

        for (int i=0;i<needs.size();i++){
            needs.set(i,needs.get(i) - special.get(i));
        }

        result += special.get(special.size() - 1);
        for (List<Integer> sp : specials){
            List<Integer> newNeed = new ArrayList<>(needs);
            dsf(result,sp,newNeed,specials,price);
        }
    }
    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(5);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(3,0,5));
        special.add(Arrays.asList(1,2,10));
        List<Integer> needs = Arrays.asList(3,2);
        System.out.println(new ShoppingOffers().shoppingOffers(price,special,needs));
    }
}
