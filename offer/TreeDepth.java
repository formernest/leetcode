class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = Math.max(TreeDepth(root.left), TreeDepth(root.right));
        return 1+depth;
    }
}