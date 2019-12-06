package breadth_first_search;

/**
 * 109. 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedListToBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode findMid(ListNode head){
        if (head.next == null)
            return head;
        if (head.next.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = head;
        while (fast.next!=null && fast.next.next!=null){
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return cur;
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.next.val);

        ListNode right = mid.next.next;
        mid.next.next = null;
        mid.next = null;

        root.right = sortedListToBST(right);
        root.left = sortedListToBST(head);

        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode l1 = new ListNode(-3);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(9);
        head.next = l1;
        l1.next = l2;l2.next = l3;l3.next = l4;
        TreeNode a = new SortedListToBST().sortedListToBST(head);
        System.out.println(1);
    }
}
