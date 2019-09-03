package depth_first_search;

import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * <p>
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class SortedListToBST$M {
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

    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        if (head == mid)
            return root;
        root.right = sortedListToBST(mid.next);
        root.left = sortedListToBST(head);
        return root;
    }

    private static ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevPtr = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prevPtr = slow;
            slow = slow.next;
        }
        if (prevPtr != null)
            prevPtr.next = null;
        return slow;
    }

    private static void print(TreeNode node) {
        print(node.left);
        System.out.println(node.val);
        print(node.right);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-10);
        ListNode listNode1 = new ListNode(-3);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(9);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        TreeNode node = sortedListToBST(listNode);
        print(node);
    }
}
