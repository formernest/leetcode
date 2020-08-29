package leetcode;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val == node2.val)
            return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
        return false;
    }
}