package leetcode;



public class num112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if ((root.left == null) && (root.right == null) && (sum - root.val == 0)) {
            return true;
        }
        boolean res = false;
        res |= hasPathSum(root.left, sum - root.val);
        res |= hasPathSum(root.right, sum - root.val);
        return res;
    }
}