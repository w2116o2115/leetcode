package string;

import java.util.ArrayList;
import java.util.List;

/**
 93. 复原IP地址
 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

 示例:

 输入: "25525511135"
 输出: ["255.255.11.135", "255.255.111.35"]

 思路：回溯
 */
public class RestoreIpAddresses$$SOS {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, "", res);
        return res;
    }
    public void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) res.add(out);
            return;
        }
        for (int k = 1; k < 4; ++k) {
            if (s.length() < k) break;
            int val = Integer.parseInt(s.substring(0, k));
            if (val > 255 || k != String.valueOf(val).length()) continue;
            helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses$$SOS().restoreIpAddresses("25525511135"));
    }
}
