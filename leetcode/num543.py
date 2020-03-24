# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    ans = 1
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.depth(root)
        return self.ans - 1

    def depth(self, root):
        if root == None:
            return 0
        L = self.depth(root.left)
        R = self.depth(root.right)
        self.ans = max(self.ans, L+R+1)
        return max(L, R) + 1        
        
        