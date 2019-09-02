package depth_first_search;

import java.util.List;

/**
 *
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
 *
 */
public class SortedListToBST$M {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.right = sortedListToBST(mid.next);
        mid.next = null;
        root.left = sortedListToBST(head);
        return root;
    }

    private static ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next !=null){
            if (fast.next != null && fast.next.next != null)
                fast = fast.next.next;
                slow = slow.next;
        }
        return slow;
    }

    private static void print(TreeNode node){
        System.out.println(node.left);
        System.out.println(node.val);
        System.out.println(node.right);
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-10);
        listNode.next = new ListNode(-3);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next = new ListNode(9);
        TreeNode node = sortedListToBST(listNode);
        print(node);
    }
}
