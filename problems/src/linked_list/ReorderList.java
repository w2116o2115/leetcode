package linked_list;

import java.util.Stack;

/**
 * 143. 重排链表
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorderList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode root = new ListNode(-1);
        root.next = head;

        Stack<ListNode> stack  = new Stack<>();
        ListNode mid = getMin(head);
        while (mid!=null){
            ListNode temp = mid.next;
            mid.next = null;
            stack.add(mid);
            mid = temp;
        }
        ListNode pre = head;
        ListNode last = head.next;
        while (!stack.isEmpty()){
            if (last == null){
                pre.next = stack.pop();
                pre = pre.next;
                continue;
            }
            ListNode temp = stack.pop();
            pre.next = temp;
            temp.next = last;
            pre = last;
            last = last!=null?last.next:null;
        }
    }

    public ListNode getMin(ListNode head){
        ListNode low = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null){
            pre = low;
            low = low.next;
            fast = fast.next.next;
        }
        if (pre != null){
            pre.next = null;
        }
        return low;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(1);
    }
}
