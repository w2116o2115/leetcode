package linked_list;

/**
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.

 */
public class SwapPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode root  = new ListNode(-1);
        root.next = head;
        ListNode pre = root;
        ListNode left = head;
        ListNode right = head.next;
        ListNode last = right.next;
        while (right != null){
            pre.next = right;
            right.next = left;
            left.next = last;

            pre = left;
            left = last;
            right = last != null ? last.next : null;
            last = right != null ? right.next : null;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode root = new SwapPairs().swapPairs(head);
        System.out.println(1);
    }
}
