package array;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 思路 单调递增的栈
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = Integer.MIN_VALUE;
        for (int i=0;i<heights.length;i++){
            while (stack.peek()!=-1 && stack.peek() >= heights[i]){
                res = Math.max(res,heights[stack.pop()]*(i-stack.peek()-1));
                stack.push(i);
            }

            while (stack.peek() != -1){
                res = Math.max(res,heights[stack.pop()]*(heights.length-stack.peek()-1));
            }
        }
        return res;
    }
}