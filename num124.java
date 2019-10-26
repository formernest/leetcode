import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class num124 {
    public int maxPathSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        if(root != null){
            stack.push(root);
            TreeNode c = null;
            while(!stack.isEmpty()){
            c = stack.peek();
            if(c.left != null && root != c.left && root != c.right){
                stack.push(c.left);
            }else if(c.right != null && root != c.right){
                stack.push(c.right);
            }else{
                TreeNode peek = stack.pop();
                int result = peek.val;
                if(peek)
                root = c;
            }
        }
    }