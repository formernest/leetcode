import java.util.ArrayList;
import java.util.Stack;
import java.util.List;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class TreeTravesal{
    public ArrayList<Integer> preOrder(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        preDfs(root, res);
        return res;
    }
    public void preDfs(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;
        res.add(root.val);
        if(root.left != null) preDfs(root.left, res);
        if(root.right != null) preDfs(root.right, res);
    }
    public ArrayList<Integer> preOrder1(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return res;
    }
    public ArrayList<Integer> inOrder(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        inDfs(root, res);
        return res;
    }
    public void inDfs(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;
        inDfs(root.left, res);
        res.add(root.val);
        inDfs(root.right, res);
    }
    public ArrayList<Integer> inOrder1(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null){   //先找到最左边的结点
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){  //弹出栈顶,打印并将开始遍历右节点,同上，找到最左
            root = stack.pop();
            res.add(root.val);
            root = root.right;
            if(root != null){
                stack.push(root);
                root = root.left;
            }
        }
        return res;
    }
    public ArrayList<Integer> postOrder(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        postDfs(root, res);
        return res;
    }
    public void postDfs(TreeNode root, ArrayList<Integer> res){
        if(root == null) return;
        postDfs(root.left, res);
        postDfs(root.right, res);
        res.add(root.val);
    }
    public ArrayList<Integer> postOrder1(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode p = root, r = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.peek();
                if(p.right != null && p.right != r){
                    p = p.right;
                }else{
                    stack.pop();
                    res.add(p.val);
                    r = p;
                    p = null;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        TreeNode root = tree.creatTree(nums);
        TreeTravesal traversal = new TreeTravesal();
        ArrayList<Integer> res = traversal.preOrder(root);
        for(int item:res){
            System.out.print(item);
            System.out.print(' ');
        }
    }
}