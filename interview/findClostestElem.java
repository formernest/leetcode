package interview;

import leetcode.TreeNode;
/*
[微软]：二叉查找树中，查找与目标值最接近的节点返回
 */
public class findClostestElem {
    int min = Integer.MAX_VALUE;

    public int getClosest(TreeNode root, int k) {
        if (root == null)
            return min;
        min = Math.min(min, Math.abs(root.val - k));
        if (k < min) {
            min = Math.min(getClosest(root.left, k), min);
        } else {
            min = Math.min(getClosest(root.right, k), min);
        }
        return min;
    }
}