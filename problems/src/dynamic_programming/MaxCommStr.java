package dynamic_programming;

import java.util.ArrayList;

/**
 * 2个字符串的最长公共子序列
 * @author Carlose wei
 * @version 1.0
 * @date 2019/10/15 17:33
 */
public class MaxCommStr {
    public static void main(String[] args) {

        String a = "damdfac";
        String b = "aadafcefc";
        String resutString = findComString(a, b);
        System.out.println(resutString);
    }

    public static String findComString(String a, String b) {
        //  a的第i个和b的第j个最大公共子序列长度：如果第i和第j个字符相同，则为a的i-1和b的j-1最大公共子序列长度+1.
        //否则取 a的第i-1个b的j个与a的i个b的j-1个中最大的。因为对比a[i-1][j-1],要不是新增的a[i]个字符与前b[j-1]的字符产生了新的匹配，
        // 要不是增加的b[j]个字符与a[i-1]个字符产生了新的匹配。如果新增的a[i]和b[j]都贡献了，
        // （如字符串ad和da，在i=1，j=1时，a[1]=d与下面的字符产生了匹配，同时b[1]=a与前者产生匹配）。因为是序列，新增的匹配要作为最后一位，所以只能任选一个作为新增的匹配。
        int[][] matrix = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    int maxLen = (i == 0 || j == 0) ? 0 : matrix[i - 1][j - 1];
                    matrix[i][j] = maxLen + 1;
                } else {
                    int maxLen = (i == 0 || j == 0) ? 0 : Math.max(
                            matrix[i - 1][j], matrix[i][j - 1]);
                    matrix[i][j] = maxLen;
                }
            }
        }

        int i = a.length() - 1;
        int j = b.length() - 1;
        ArrayList<Character> restList = new ArrayList<>();
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == b.charAt(j)) {
                restList.add(a.charAt(i));
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
        StringBuilder reBuilder = new StringBuilder(restList.size());
        for (int k = restList.size() - 1; k >= 0; k--) {
            reBuilder.append(restList.get(k));
        }
        return reBuilder.toString();
    }
}
