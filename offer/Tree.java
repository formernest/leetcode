import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Tree{
    public TreeNode creatTree(int[] nums){
        if(nums.length == 0) return null;
        TreeNode root = new TreeNode(nums[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for(int i=1; i< nums.length; i+=2){
            TreeNode left = null;
            TreeNode right = null;
            if(nums[i] != -1){
                left = new TreeNode(nums[i]);
            }
            if(i+1<nums.length && nums[i+1] != -1){
                right = new TreeNode(nums[i+1]);
            }
            TreeNode peek = stack.pop();
            peek.left = left;
            peek.right = right;
            stack.push(peek.left);
            stack.push(peek.right);
        }
        return root;
    }
}

            

