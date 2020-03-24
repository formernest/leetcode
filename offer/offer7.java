
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class offer7 {
    // 重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null ||pre.length != in.length) return null;
        else{
            TreeNode node = reConstruct(pre, in, 0, pre.length-1, 0, in.length-1);
            return node;
        }
    }
    public static TreeNode reConstruct(int [] pre,int [] in, int istart, int iend, int pstart, int pend){
        if(pstart>pend || istart>iend) return null;
        TreeNode node = new TreeNode(pre[pstart]);
        for(int i=istart; i<=iend; i++){
            if(in[i] == pre[pstart]){
                node.left = reConstruct(pre, in, istart, i-1, pstart+1, pstart+i-istart);
                node.right = reConstruct(pre, in, i+1, iend, pstart+i-istart+1, pend);
            }
        }
        return node;
    }
}