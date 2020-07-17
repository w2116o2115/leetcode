package tencent;

/**
 * 2. 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
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
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode current = null;
        while (l1!=null || l2 != null || carry !=0){
            int num1 = l1 != null ? l1.val:0;
            int num2 = l2 != null ? l2.val:0;
            int sum = num1+num2+carry;
            int res = sum % 10;
            ListNode node = new ListNode(res);
            if (head.next == null) head.next = node;
            if (current != null) {
                current.next = node;
                current = current.next;
            }else {
                current = node;
            }
            carry = sum /10;
            l1 = l1!=null?l1.next : null;
            l2 = l2!=null?l2.next : null;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode head = new AddTwoNumbers().addTwoNumbers(l1,l2);
        System.out.println(1);
    }
}