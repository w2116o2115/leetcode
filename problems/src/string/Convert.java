package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 0 1 2 3 4
 * 6. Z 字形变换
 * @author Carlose wei
 * @version 1.0
 * @date 2019/11/20 11:08
 */
public class Convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static void main(String[] args) {
        new Convert().convert("LEETCODEISHIRING",3);
    }
}
