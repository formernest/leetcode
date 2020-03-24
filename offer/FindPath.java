import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int sum = 0;
        help(root, target, result, temp, sum);
        return result;
    }
    public void help(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int sum){
        if(root == null) return;
        sum += root.val;
        if(root.left == null && root.right == null){  //遇到叶节点的时候计算sum是否等于target
            if(sum == target){
                temp.add(root.val);
                result.add(new ArrayList<>(temp));  
                temp.remove(temp.size()-1);  // 回溯
            }
            return;
        }
        temp.add(root.val);
        help(root.left, target, result, temp, sum);  // 结算左子树
        help(root.right, target, result, temp, sum);  // 结算右子树
        temp.remove(temp.size()-1);
    }
}