
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class num124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        rootSum(root);
        return max;
    }
    public int rootSum(TreeNode root){
        if(root == null) return 0;
        int ls = rootSum(root.left);
        int rs = rootSum(root.right);
        this.max = Math.max(max, root.val + ls + rs);
        this.max = Math.max(max, root.val);
        int leftAcur = root.val + ls;
        int rightAcur = root.val + rs;
        this.max = Math.max(max, leftAcur);
        this.max = Math.max(max, rightAcur);
        if(leftAcur < 0 && rightAcur < 0){
            return root.val < 0 ? 0 : root.val;
        }
        return leftAcur > rightAcur? leftAcur : rightAcur;
    }
}