package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 638. 大礼包
 * 在LeetCode商店中， 有许多在售的物品。

 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。

 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。

 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。

 任意大礼包可无限次购买。

 示例 1:

 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
 输出: 14
 解释:
 有A和B两种物品，价格分别为¥2和¥5。
 大礼包1，你可以以¥5的价格购买3A和0B。
 大礼包2， 你可以以¥10的价格购买1A和2B。
 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。

 思路 ：1 定义全局minPrice
       2 初始化 minPrice 不用special 需要的钱
       3 定义 helper 一个一个 special的去回溯 ，需要判断当前的special是否可用
       4 遍历完左右的special 的时候需要把剩下的needs 不用special进行计算
 */
public class ShoppingOffers$$retry {
    private int minPrice = Integer.MAX_VALUE;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        minPrice = buyWithoutSpecial(price,needs);
        helper(price,special,needs,0,0);
        return minPrice;
    }

    private void helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs,int index,int used){
        if (used >= minPrice) return;
        if (index == special.size()){
            used += buyWithoutSpecial(price,needs);
            if (used < minPrice){
                minPrice = used;
            }
            return;
        }

        List<Integer> offer = special.get(index);
        if (canUse(offer,needs)){
            List<Integer> newUpdate = new ArrayList<>();
            for (int i=0;i<needs.size();i++){
                newUpdate.add(needs.get(i) - offer.get(i));
            }
            helper(price,special,newUpdate,index,used+offer.get(offer.size()));
        }
        helper(price,special,needs,index+1,used);
    }

    private int buyWithoutSpecial(List<Integer> price, List<Integer> needs) {
        for (int i=0;i<price.size();i++){
            minPrice+=price.get(i)*needs.get(i);
        }
        return minPrice;
    }

    private boolean canUse(List<Integer> offer,List<Integer> needs){
        for (int i=0;i<offer.size();i++){
            if (needs.get(i) < offer.get(i)){
                return false;
            }
        }
        return true;
    }
}
