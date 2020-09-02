package leetcode;

class num108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return getTree(nums, 0, nums.length - 1);
    }

    public TreeNode getTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getTree(nums, start, mid - 1);
        root.right = getTree(nums, mid + 1, end);
        return root;
    }

}