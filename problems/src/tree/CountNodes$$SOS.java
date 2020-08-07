package tree;

/**
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。
 *      所以左子树的节点总数我们可以直接得到，是2^left - 1，加上当前这个root节点，则正好是2^left。再对右子树进行递归统计。
 * left != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。
 *      同理，右子树节点+root节点，总数为2^right。再对左子树进行递归查找。
 */
public class CountNodes$$SOS {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public int countNodes(TreeNode root) {
//        int res = 0;
//        if (root == null) return res;
//        int level = findLevel(root);
//        for (int i=0;i<level-1;i++){
//            res += (1<<i);
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            int count = queue.size();
//            level--;
//            if (level == 0) {
//                res += queue.size();
//                break;
//            }
//            while (count --> 0){
//                TreeNode node = queue.poll();
//                if (node.left!=null) queue.add(node.left);
//                if (node.right!=null) queue.add(node.right);
//            }
//        }
//        return res;
//    }
//
//    private int findLevel(TreeNode node){
//        TreeNode root = node;
//        int count  = 0;
//        if (root == null) return count;
//        while (root!=null){
//            count++;
//            root = root.left;
//        }
//        return count;
//    }
public int countNodes(TreeNode root) {
    if(root == null){
        return 0;
    }
    int left = countLevel(root.left);
    int right = countLevel(root.right);
    if(left == right){
        return countNodes(root.right) + (1<<left);//left == right 说明左子树是满的，直接计算左子树的节点 2^left - 1 + root = 2^left
    }else{
        return countNodes(root.left) + (1<<right);//left != right 说明右子树不满，但是倒数第二排已经满了，  2^right - 1 + root = 2^right
    }
}
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new CountNodes$$SOS().countNodes(root));

        System.out.println( 1<<2);
    }
}