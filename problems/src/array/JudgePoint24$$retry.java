package array;

/**
 * 679. 24 点游戏
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 示例 1:
 *
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 *
 * 输入: [1, 2, 1, 2]
 * 输出: False
 *
 * 思路： 可以先把两个数先拿出来让后计算，在放回去，就变成3个数算24点
 *        本质上是个递归算法
 */
public class JudgePoint24$$retry {
    public boolean judgePoint24(int[] nums) {
        double[] n = new double[]{nums[0],nums[1],nums[2],nums[3]};
        return helper(n);
    }

    public static boolean helper(double[] n){
        if (n.length == 1) return Math.abs(24 - n[0]) < 0.01;
        for (int i=0;i<n.length;i++){
            for (int j=i+1;j<n.length;j++){
                double[] b = new double[n.length-1];
                for (int k=0,index =0;k<n.length;k++){
                    if (k!=i && k!=j) {
                        b[index++] = n[k];
                    }
                }
                for (double d:comput(n[i],n[j])){
                    b[b.length-1] = d;
                    if (helper(b)) return true;
                }
            }
        }
        return false;
    }

    public static double[] comput(double x,double y){
        return new double[]{x+y,x-y,y-x,x*y,x/y,y/x};
    }
}