
 //* Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class num1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length != 0){
            TreeNode root = new TreeNode(preorder[0]);
            int index = 1;
            while(preorder[index] < preorder[0]){
                index ++;
            }
            root.left = bstFromPreorder(preorder[1, index]);
            root.right = bstFromPreorder(preorder[index:]);
            return root;
        }else{
            return null;
        }
    }
}