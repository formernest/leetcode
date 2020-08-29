package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class num102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            List<Integer> interlist = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode front = q.poll();
                interlist.add(front.val);
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            list.add(interlist);
        }

        return list;
    }

    public static void main(String[] args) {

    }
}