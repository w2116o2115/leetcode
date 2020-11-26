package tree;

/**
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * 思路：
 * 二叉搜索树的三个特性：
 * 1  二叉搜索树的中序遍历的序列是递增排序的序列。中序遍历的遍历次序：Left -> Node -> Right。
 * 2  Successor 代表的是中序遍历序列的下一个节点。即比当前节点大的最小节点，简称后继节点。
 *    先取当前节点的右节点，然后一直取该节点的左节点，直到左节点为空，则最后指向的节点为后继节点。
 *    public int successor(TreeNode root) {
 *      root = root.right;
 *      while (root.left != null) root = root.left;
 *      return root;
 *   }
 *
 * 3 Predecessor 代表的是中序遍历序列的前一个节点。即比当前节点小的最大节点，简称前驱节点。
 *   先取当前节点的左节点，然后取该节点的右节点，直到右节点为空，则最后指向的节点为前驱节点。
 *
 *   public int predecessor(TreeNode root) {
 *      root = root.left;
 *      while (root.right != null) root = root.right;
 *      return root;
 *   }
 *  这里有三种可能的情况：
 *
 *      要删除的节点为叶子节点，可以直接删除。
 *
 *      要删除的几点不是叶子节点且拥有右节点，则该节点可以由该节点的后继节点进行替代，该后继节点位于右子树中较低的位置。
 *      然后可以从后继节点的位置递归向下操作以删除后继节点。
 *
 *      要删除的节点不是叶子节点，且没有右节点但是有左节点。这意味着它的后继节点在它的上面，但是我们并不想返回。
 *      我们可以使用它的前驱节点进行替代，然后再递归的向下删除前驱节点。
 *
 * 二叉搜索树的性质：
 *  1 二叉搜索树的中序遍历的序列是递增排序的序列。中序遍历的遍历次序：Left -> Node -> Right。
 */
public class DeleteNode$$retry$$retry {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
      Successor 代表的是中序遍历序列的下一个节点。即比当前节点大的最小节点，简称后继节点。 先取当前节点的右节点，
                然后一直取该节点的左节点，直到左节点为空，则最后指向的节点为后继节点。
      */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
     Predecessor 代表的是中序遍历序列的前一个节点。即比当前节点小的最大节点，简称前驱节点。先取当前节点的左节点，
                 然后取该节点的右节点，直到右节点为空，则最后指向的节点为前驱节点。
    */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        //如果 key > root.val，说明要删除的节点在右子树，root.right = deleteNode(root.right, key)。
        //如果 key < root.val，说明要删除的节点在左子树，root.left = deleteNode(root.left, key)。
        //如果 key == root.val，则该节点就是我们要删除的节点，则：
        //如果该节点是叶子节点，则直接删除它：root = null。
        //如果该节点不是叶子节点且有右节点，则用它的后继节点的值替代 root.val = successor.val，然后删除后继节点。
        //如果该节点不是叶子节点且只有左节点，则用它的前驱节点的值替代 root.val = predecessor.val，然后删除前驱节点。
        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null && root.right == null) root = null;
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}