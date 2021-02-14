package string;

/**
 * 640. 求解方程
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
   如果方程没有解，请返回“No solution”。
   如果方程有无限解，则返回“Infinite solutions”。
   如果方程中只有一个解，要保证返回值 x 是一个整数。

 输入: "x+5-3+x=6+x-2"
 输出: "x=2"
   思路: 左右分别处理。
 */
public class SolveEquation$$retry {
    public String solveEquation(String equation) {
        String ret = null;
        try {
            String[] split = equation.split("=");
            String left = split[0];
            String right = split[1];
            int[] leftRet = splitVar(left);
            int[] rightRet = splitVar(right);
            int xNum = leftRet[0] - rightRet[0];
            int constNum = rightRet[1] - leftRet[1];
            if (xNum != 0) {
                return "x=" + constNum / xNum;
            }
            if (constNum == 0) {
                return "Infinite solutions";
            }
            return "No solution";
        } catch (Exception ex) {
            ret =  "No solution";
        }
        return ret;
    }

    int[] splitVar(String str) {
        String[] split = str.replace("-", "+-").split("\\+");
        int sumX = 0;
        int sumS = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("x")) {
                sumX++;
            } else if (split[i].equals("-x")) {
                sumX--;
            } else if (split[i].contains("x")) {
                sumX += Integer.valueOf(split[i].substring(0, split[i].length() - 1));
            } else if (!split[i].equals("")) {
                sumS += Integer.valueOf(split[i]);
            } else {
                continue;
            }
        }
        return new int[]{sumX, sumS};
    }
}
