package leetcode;
/**
 * 二叉树的右视图
 */
import java.util.LinkedList;
import java.util.List;

public class num199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                TreeNode node = queue.pollFirst();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(size==0) list.add(node.val);
            }
        }
        return list;
    }
}