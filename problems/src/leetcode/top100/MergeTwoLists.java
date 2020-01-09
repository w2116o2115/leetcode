package leetcode.top100;

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode curNode = null;
        while (l1!=null && l2 != null){
            if (curNode==null) {
                curNode = l1.val > l2.val?l2:l1;
            } else {
                curNode.next = l1.val > l2.val?l2:l1;
                curNode = curNode.next;
            }
            if (root == null) root = curNode;
            if (l1.val > l2.val){
                l2 = l2.next;
            }else {
                l1 = l1.next;
            }
            curNode.next = null;
        }
        while (l1 != null){
            if (root == null){
               curNode = l1;
               root = curNode;
            }else {
                curNode.next = l1;
                curNode = curNode.next;
            }
            l1 = l1.next;
            curNode.next = null;
        }
        while (l2 != null){
            if (root == null){
                curNode = l2;
                root = curNode;
            }else {
                curNode.next = l2;
                curNode = curNode.next;
            }
            l2 = l2.next;
            curNode.next = null;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);

        ListNode root = new MergeTwoLists().mergeTwoLists(null,new ListNode(0));
        System.out.println(1);
    }
}
