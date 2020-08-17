package dynamic_programming;

/**
 * 2个字符串的最长公共子序列
 * @author Carlose wei
 * @version 1.0
 * @date 2019/10/15 17:33
 */
public class MaxCommStr$SOS {
    public static void main(String[] args) {

        String a = "damdfac";
        String b = "aadafcefc";
        String resutString = findComString(a, b);
        System.out.println(resutString);
    }

    public static String findComString(String a, String b) {
        //https://blog.csdn.net/hrn1216/article/details/51534607
        int[][] matrix = new int[a.length() + 1][b.length() + 1];
        matrix[0][0] = a.charAt(0) == b.charAt(0) ? 1:0;
        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder reBuilder = new StringBuilder();
        while (i > 0 && j > 0) {
            if (a.charAt(i) == b.charAt(j)) {
                reBuilder.append(a.charAt(i));
                i--;
                j--;
            } else {
                if (matrix[i - 1][j] >= matrix[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return reBuilder.reverse().toString();
    }
}
