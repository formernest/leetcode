package leetcode;


public class num110 {
    boolean isbalanced = true;

    // public boolean isBalanced(TreeNode root) {
    //     getDepth(root);
    //     return isbalanced;
    // }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isbalanced = false;
        }
        return right > left ? right + 1 : left + 1;
    }
}