import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Print {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while(queue.size()!=0){
            int size = queue.size();
            ArrayList<Integer> items = new ArrayList<>();
            while(size > 0){
                TreeNode node = queue.pollFirst();
                items.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                size -= 1;
            }
            result.add(items);
        }
        return result;
    }
    
}