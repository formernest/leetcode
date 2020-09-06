package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode cur = null;
            while (!stack.isEmpty()) {
                cur = stack.peek();
                if (cur.left != null && root != cur.left && root != cur.right) {
                    stack.push(cur.left);
                } else if (cur.right != null && cur != cur.right) {
                    stack.push(cur.right);
                } else {
                    res.add(stack.pop().val);
                    root = cur;
                }
            }
        }
        return res;
    }
}