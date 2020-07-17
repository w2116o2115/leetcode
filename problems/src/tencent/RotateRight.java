package tencent;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class RotateRight {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode rotateRight(ListNode head, int k) {
        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode fast = head;
        ListNode slow = head;

        while (k --> 0){
            fast = fast.next;
        }

        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        root.next = slow.next;
        slow.next = null;
        fast.next = head;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        root.next = node1;node1.next = node2;
        node2.next = node3;node3.next = node4;

        ListNode head = new RotateRight().rotateRight(root,2);
        System.out.println(1);
    }
}