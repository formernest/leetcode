package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();
        int count = 1;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            List<Integer> inlist = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode front = q.poll();
                inlist.add(front.val);
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            if (count % 2 == 0) {
                reverse(inlist);
            }
            list.add(inlist);
            count++;
        }
        return list;
    }

    public static void reverse(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            int front = list.get(i);
            int tail = list.get(size - 1 - i);
            list.set(i, tail);
            list.set(size - 1 - i, front);
        }
    }

}