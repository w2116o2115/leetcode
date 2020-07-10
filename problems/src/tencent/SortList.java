package tencent;

/**
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 */
public class SortList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
    }

    private ListNode merge(ListNode left,ListNode right){
        ListNode root = new ListNode(0);
        ListNode current = root;
        while (left!=null && right != null){
            if (left.val > right.val){
                current.next = right;
                right = right.next;
            }else {
                current.next = left;
                left = left.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }

        return root.next;
    }

    private ListNode getMid(ListNode listNode){
        if (listNode.next == null) return listNode;
        ListNode slow = listNode;
        ListNode fast = listNode;
        ListNode pre = null;
        while (fast!=null && fast.next !=null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        return slow;
    }
}