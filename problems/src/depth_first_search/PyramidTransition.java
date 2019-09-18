package depth_first_search;

import java.util.List;

/**
 * 756. 金字塔转换矩阵
 *
 * 现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示，例如 “Z”。
 *
 * 使用三元组表示金字塔的堆砌规则如下：
 *
 * (A, B, C) 表示，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。
 *
 * 初始时，给定金字塔的基层 bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。
 *
 * 如果可以由基层一直堆到塔尖返回true，否则返回false。
 *
 * 示例 1:
 *
 * 输入: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
 * 输出: true
 * 解析:
 * 可以堆砌成这样的金字塔:
 *     A
 *    / \
 *   D   E
 *  / \ / \
 * X   Y   Z
 *
 * 因为符合('X', 'Y', 'D'), ('Y', 'Z', 'E') 和 ('D', 'E', 'A') 三种规则。
 * 示例 2:
 *
 * 输入: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
 * 输出: false
 * 解析:
 * 无法一直堆到塔尖。
 * 注意, 允许存在三元组(A, B, C)和 (A, B, D) ，其中 C != D.
 *
 * 3 12  23
 * 4 12 34
 */
public class PyramidTransition {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (bottom.length() % 2 == 0){
            System.out.println(1);
        }else {
            for (int i=0;i<bottom.length();i++){
                if (i+1 >= bottom.length())
                    break;
                System.out.println(bottom.substring(i,i+2));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new PyramidTransition().pyramidTransition("XYZ",null);
    }
}