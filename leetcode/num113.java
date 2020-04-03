package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class num113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        getSum(res, root, new LinkedList<>(), sum);
        return res;
    }
    public void getSum(List<List<Integer>> res, TreeNode root, LinkedList<Integer> temp, int sum){
        if(root == null){
            return;
        }
        temp.add(root.val);
        if((root.left == null) && (root.right == null) && (sum==root.val)){
            res.add(new ArrayList<>(temp));
            temp.removeLast();
            return;
        }
        getSum(res, root.left, temp, sum-root.val);
        getSum(res, root.right, temp, sum-root.val);
        temp.removeLast();
    }
}