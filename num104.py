# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.getDepth(root)
    
    def getDepth(self, root):
        if root is None:
            return 0
        L = self.getDepth(root.left)
        R = self.getDepth(root.right)
        return max(L, R) + 1
        