package leetcode.bigo;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution1 {
    public int getMax (TreeNode root) {
        if (root == null) return 0;
        int res = Math.max(getDepth(root), Math.max(getDepth(root.left), getDepth(root.right)));
        return res;
    }
    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return left + right + 1;
    }
}