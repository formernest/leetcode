package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class num236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        stack.push(root);
        map.put(root, null);
        while(!map.containsKey(p) || !map.containsKey(q)){
            root = stack.pop();
            if(root.left != null){
                stack.push(root.left);
                map.put(root.left, root);
            }
            if(root.right != null){
                stack.push(root.right);
                map.put(root.right, root);
            }
        }
        Set<TreeNode> ancestor = new HashSet<>();
        while(p!=null){
            ancestor.add(p);
            p = map.get(p);
        }
        while(!ancestor.contains(q)){
            q = map.get(q);
        }
        return q;
    }
}
