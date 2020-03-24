import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class num94 {
    // public ArrayList<Integer> inorderTraversal(TreeNode root) {
    //     ArrayList<Integer> array = new ArrayList<>();
    //     if(root == null) return array;
    //     inorder(root, array);
    //     return array;
    // }

    // public void inorder(TreeNode root, ArrayList<Integer> array) {
    //     if(root.left != null) inorder(root.left, array);
    //     array.add(root.val);
    //     if(root.right != null) inorder(root.right, array);
    // }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<>();
        if(root == null) return array;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p = root;
        while(!stack.isEmpty()){
            if(p != null && p.left != null){
                stack.push(p.left);
                p = p.left;
            }else{
                p = stack.pop();
                array.add(p.val);
                if(p != null && p.right != null){
                    stack.push(p.right);
                    p = p.right;
                }else{
                    p = null;
                }
            }
        }
        return array;
    }
}