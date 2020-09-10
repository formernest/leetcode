package leetcode;

public class num111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = 0;
        int right = 0;
        left = 1 + minDepth(root.left);
        right = minDepth(root.right);
        return Math.min(left + 1, right + 1);
    }
}