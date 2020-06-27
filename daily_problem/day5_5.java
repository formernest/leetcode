package daily_problem;
/**
 * 验证二叉搜索树
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class day5_5 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer lower, Integer upper) {
        if(node == null) return true;
        int val = node.val;
        if(lower != null && lower >= val) return false;
        if(upper != null && upper <= val) return false;
        if(!isValid(node.left, lower, val)) return false;
        if(!isValid(node.right, val, upper)) return false;
        return true;
    }
}