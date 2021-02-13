package stack;

import java.util.Stack;

/**
 * 735. 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
   对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。
   每一颗行星以相同的速度移动。

   找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。
   两颗移动方向相同的行星，永远不会发生碰撞。

 输入：asteroids = [5,10,-5]
 输出：[5,10]
 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 */
public class AsteroidCollision$$retry {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid * stack.peek() > 0 || (stack.peek() < 0 && asteroid > 0)) {
                stack.push(asteroid);
            } else {
                boolean flag = true;
                while (!stack.isEmpty() && stack.peek() * asteroid < 0) {
                    if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                        stack.pop();
                        flag = false;
                        break;
                    } else if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) stack.push(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        int index = res.length-1;
        while (!stack.isEmpty()){
            res[index--] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        new AsteroidCollision$$retry().asteroidCollision(new int[]{1,-2,-1,-2});
    }
}
