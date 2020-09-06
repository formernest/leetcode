package leetcode;

import java.util.ArrayList;
import java.util.List;

public class num257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        backTrack(result, root, "");
        return result;
    }

    private void backTrack(List<String> result, TreeNode root, String s) {
        if (root != null) {
            StringBuffer sb = new StringBuffer(s);
            sb.append(String.valueOf(root.val));
            if (root.left == null && root.right == null) {
                result.add(sb.toString());
            } else {
                sb.append("->");
                backTrack(result, root.left, sb.toString());
                backTrack(result, root.right, sb.toString());
            }

        }
    }
}
