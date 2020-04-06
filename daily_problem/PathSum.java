package daily_problem;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        help(result, new ArrayList<Integer>(), root, sum);
        return result;
    }
    public void help(List<List<Integer>> result, ArrayList<Integer> temp, TreeNode root, int sum){
        if(root == null) return;
        temp.add(root.val);
        if(sum == 0 && root.left == null && root.right == null){
            result.add(new ArrayList<>(temp));
        }
        help(result, temp, root.left, sum - root.val);
        help(result, temp, root.right, sum - root.val);
        temp.remove(temp.size()-1);
    }
    public static void main(String[] args) {
        
    }
}