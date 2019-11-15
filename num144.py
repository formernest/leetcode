# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        array = []
        if root is None: 
            return array
        stack = []
        stack.append(root)
        while len(stack) != 0:
            p = stack.pop()
            array.append(p.val)
            if p.right is not None:
                stack.append(p.right)
            if p.left is not None:
                stack.append(p.left)
        return array