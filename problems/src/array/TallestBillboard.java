package array;

/**
 * 956. 最高的广告牌
 * 你正在安装一个广告牌，并希望它高度最大。这块广告牌将有两个钢制支架，两边各一个。每个钢支架的高度必须相等。
 *
 * 你有一堆可以焊接在一起的钢筋 rods。举个例子，如果钢筋的长度为 1、2 和 3，则可以将它们焊接在一起形成长度为 6 的支架。
 *
 * 返回广告牌的最大可能安装高度。如果没法安装广告牌，请返回 0。
 *
 * 输入：[1,2,3,6]
 * 输出：6
 * 解释：我们有两个不相交的子集 {1,2,3} 和 {6}，它们具有相同的和 sum = 6。
 *
 * 思路 : 每个数字有三种情况， 1. 加在左边  2.加在右边  3 不用
 *        剪纸 ： left + right + unchecked <= 2*max
 *                Math.abs(left - right) > unchecked  如果加上上下的 都没法让木桶找平，就没有找下去的意义了
 */
public class TallestBillboard {
    private int max = 0;
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int rod:rods){
            sum+=rod;
        }
        helper(rods,rods.length-1,0,0,sum);
        return max;
    }

    private void helper(int[] rods,int index,int left ,int right ,int unchecked){
        if (index < 0) {
            if (left == right)
                max = Math.max(max, left);
            return;
        }
        if ((left+right+unchecked) <= 2*max || Math.abs(left-right) > unchecked)
            return;
        helper(rods,index-1,left+rods[index],right,unchecked-rods[index]);
        helper(rods,index-1,left,right+rods[index],unchecked-rods[index]);
        helper(rods,index-1,left,right,unchecked-rods[index]);
    }

    public static void main(String[] args) {
        System.out.println(new TallestBillboard().tallestBillboard(new int[]{1,2,3,6}));
    }
}