package leetcode.easy;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur!=null && cur.next!=null){
            if (cur.val != cur.next.val) {
                cur = cur.next;
                continue;
            }else {
                cur.next = cur.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        head.next = l1;

        ListNode root = new DeleteDuplicates().deleteDuplicates(head);
        System.out.println(1);
    }
}
