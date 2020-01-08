package leetcode.easy;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;

import java.util.Stack;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindromeLinked {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (fast!=null && fast.next!=null){
            stack.add(slow);
            slow = slow.next;
            fast = fast.next.next;
            count = fast == null?count+1:count+2;
        }
        if (count%2==0) slow = slow.next;
        while (!stack.isEmpty() && slow!=null){
            if (slow.val != stack.pop().val)
                return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = null;
        System.out.println(new IsPalindromeLinked().isPalindrome(head));
    }
}
