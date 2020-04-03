package leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class num437{
    int count = 0;
    int totalPaths = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root!=null){
            traverseAllPaths(root, sum, 0);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
        }
        return  totalPaths;
    }

    private void traverseAllPaths(TreeNode root, int sum, int currentSum){
        if(root !=null){   
            currentSum += root.val;
            if(sum == currentSum){
                totalPaths++;
            }
            traverseAllPaths(root.left, sum, currentSum);
            traverseAllPaths(root.right, sum, currentSum);
        }
    }
}