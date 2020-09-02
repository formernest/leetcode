package interview;

import leetcode.TreeNode;

/**
 * [程序员面试]：查找二叉树中两个节点的最近公共祖先
 */
public class lowCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }
}