package array;

/**
 * 11. 盛最多水的容器
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class MaxArea {
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i=0;i<height.length;i++){
            for (int j = i+1;j<height.length;j++){
                max = Math.max(max,Math.min(height[j],height[i])*(j-i));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
