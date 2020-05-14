package string;

/**
 * 553. 最优除法
 *
 * 给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。
 *
 * 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。
 *
 * 示例：
 *
 * 输入: [1000,100,10,2]
 * 输出: "1000/(100/10/2)"
 * 解释:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * 但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
 * 因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
 *
 * 其他用例:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 *
 * 思路：这题咋看起来很复杂，好像是有限空间搜索的问题，但是由于所以数都是正整数，结果就只有一种可能了，就是
 * A/(B/C/D/...).
 */
public class OptimalDivision$$SOS {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        if (nums.length == 1) return sb.toString();
        sb.append('/');
        if (nums.length == 2) {
            sb.append(nums[1]);
            return sb.toString();
        }
        sb.append('(');
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]);
            sb.append('/');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');

        return sb.toString();
    }
}