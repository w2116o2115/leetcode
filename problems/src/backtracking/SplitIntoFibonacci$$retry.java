package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * 输入："123456579"
 * 输出：[123,456,579]
 *
 * 回溯 ： 由于只需要找到一个解，所有 backtrack 需要返回一个boolean
 *         回溯的两部分：
 *                      backCase
 *                      backTrack
 */
public class SplitIntoFibonacci$$retry {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        helper(S,res,0);
        return res;
    }

    private static boolean helper(String s,List<Integer> res,int index){
        if (index == s.length()) {
            return res.size() > 2;
        }
        int num = 0;
        int n = s.length();
        for (int i=index;i<n;i++){
            num = num*10+(s.charAt(i)-'0');
            if (num < 0) return false;
            if (res.size() < 2 || (res.get(res.size()-2) + res.get(res.size()-1)) == num) {
                res.add(num);
                if (helper(s, res, i + 1)) return true;
                res.remove(res.size()-1);
                if (i == index && s.charAt(i) == '0') return false;//如果第一位0 就没有必要在去找了
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SplitIntoFibonacci$$retry().splitIntoFibonacci("123456579"));
    }
}