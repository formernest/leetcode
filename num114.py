# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: None Do not return anything, modify root in-place instead.
        """
        if root is None:
            return root
        stack = []
        stack.append(root)
        current = TreeNode(0)
        while len(stack) != 0:
            peek = stack.pop()
            current.left = None
            current.right = peek
            current = current.right
            if peek.right != None:
                stack.append(peek.right)
            if peek.left != None:
                stack.append(peek.left)        
        return root
        
if __name__ == "__main__":
    nums = [1,2,5,3,4,None,6]
    root  = TreeNode(nums[0])
    queue = []
    for item in nu
