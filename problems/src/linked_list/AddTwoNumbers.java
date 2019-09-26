package linked_list;

import java.math.BigInteger;

/**
 * 445. 两数相加 II
 *
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *  
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        StringBuilder sb1 = new StringBuilder();
        while (l1!=null){
            sb1.append(l1.val);
            l1 = l1.next;
        }
        StringBuilder sb2 = new StringBuilder();
        while (l2!=null){
            sb2.append(l2.val);
            l2 = l2.next;
        }

        BigInteger res = new BigInteger(sb1.toString()).add(new BigInteger(sb2.toString()));
        char[] nums = res.toString().toCharArray();
        ListNode root = new ListNode(-1);
        ListNode head = root;
        for (char n : nums){
             root.next = new ListNode((Integer.valueOf(String.valueOf(n))));
             root = root.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        l1.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode l2 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        l2.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode root = new AddTwoNumbers().addTwoNumbers(l1,l2);
        System.out.println(1);
    }
}
