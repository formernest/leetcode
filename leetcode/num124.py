# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.res = -float('inf')
        def rootSum(node):
            if not node:
                return 0
            ls = rootSum(node.left)
            rs = rootSum(node.right)
            self.res = max(self.res, node.val+max(ls+rs, ls, rs, 0))
            if ls >= rs and ls > 0:
                return node.val + ls
            if rs >= ls and rs > 0:
                return node.val + rs
        
        rootSum(root)
        return self.res

if __name__ == "__main__":
    pass