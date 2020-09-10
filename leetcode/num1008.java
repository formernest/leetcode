package leetcode;

public class num1008 {
    public TreeNode bstFromPreorder(int[] preorder, int from, int to) {
        if (preorder.length != 0) {
            TreeNode root = new TreeNode(preorder[0]);
            int index = 1;
            while (preorder[index] < preorder[0]) {
                index++;
            }
            root.left = bstFromPreorder(preorder, 1, index);
            root.right = bstFromPreorder(preorder, index, preorder.length);
            return root;
        } else {
            return null;
        }
    }
}