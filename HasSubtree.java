import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null) return false;
        if(root1 == null) return false;
        boolean flag = false;
        if(root1.val == root2.val){
            flag = help(root1.left, root2.left) && help(root1.right, root2.right);
        }
        if(!flag){
            flag = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return flag;
    }
    public boolean help(TreeNode root1, TreeNode root2){
        if(root2 == null) return true;
        if(root1 == null && root2 != null) return false;
        if(root1.val != root2.val) return false;
        return help(root1.left, root2.left) && help(root1.right, root2.right);
    }
}