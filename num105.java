import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 
class num105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || preorder.length != inorder.length) return null;
        int[] peek = new int[1];
        peek[0] = 0;
        return build(peek, 0, inorder.length-1, preorder, inorder);
    }
    public TreeNode build(int[] peek, int start, int end, int[] preorder, int[] inorder) {
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[peek[0]++]);
        if(start == end) return root;
        int t = start;
        while(t <= end && inorder[t] != preorder[peek[0]-1]) t++;
        root.left = build(peek, start, t-1, preorder, inorder);
        root.right = build(peek, t+1, end, preorder, inorder);
        return root;
    }
    public static void main(String[] args) {
        int[] preorder = {1,2};
        int[] inorder = {1,2};
        num105 solution = new num105();
        TreeNode root = solution.buildTree(preorder, inorder);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode peek = queue.poll();
            if(peek != null){
                System.out.println(peek.val);
            }else{
                System.out.println("null");
            }
            if(peek != null){
                queue.add(peek.left);
                queue.add(peek.right);
            }
        }
    }
}