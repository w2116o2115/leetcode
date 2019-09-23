package linked_list;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *     0
 *   /  \
 *  -3   9
 *  /   /
 * -10 5
 */
public class SortedListToBST {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode mid = this.getMid(head);
        TreeNode root = new TreeNode(mid.val);
        if (head == mid) {
            return root;
        }
        root.right = sortedListToBST(mid.next);
        root.left = sortedListToBST(head);
        return root;
    }

    private ListNode getMid(ListNode head){
        ListNode prevPtr = null;
        ListNode fast_node = head;
        ListNode slow_node = head;
        while (fast_node !=null && fast_node.next !=null){
            prevPtr = slow_node;
            slow_node = slow_node.next;
            fast_node = fast_node.next.next;
        }
        if (prevPtr != null){ //把链表断开
            prevPtr.next = null;
        }
        return slow_node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        TreeNode root = new SortedListToBST().sortedListToBST(head);
        System.out.println(1);
    }
}
