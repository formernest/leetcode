import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class zPrint {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(pRoot);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            
            if(!stack1.isEmpty()){
                ArrayList<Integer> items = new ArrayList<>();
                while(!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    items.add(node.val);
                    if(node.left != null) stack2.add(node.left);
                    if(node.right != null) stack2.add(node.right);
                }
                result.add(items);
            }else{
                ArrayList<Integer> items = new ArrayList<>();
                while(!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    items.add(node.val);
                    if(node.right != null) stack1.add(node.right);
                    if(node.left != null) stack1.add(node.left);
                }
                result.add(items);
            }  
        }
        return result;
    }

}