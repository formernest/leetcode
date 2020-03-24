class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
class num226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        return invert(root);
    }
    public TreeNode invert(TreeNode root) {
        if(root.left != null || root.right != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left != null) invert(root.left);
            if(root.right != null) invert(root.right);
        }
        return root;
    }
}