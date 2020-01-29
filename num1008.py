# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def bstFromPreorder(self, preorder):
        """
        :type preorder: List[int]
        :rtype: TreeNode
        """
        if len(preorder) == 0:
            return None
        root = TreeNode(preorder[0])
        left = []
        right = []
        for i in range(1, len(preorder)):
            if preorder[i] < preorder[0]:
                left.append(preorder[i])
            else:
                right.append(preorder[i])
        root.left = self.bstFromPreorder(left)
        root.right = self.bstFromPreorder(right)
        return root

if __name__ == "__main__":
    solution = Solution()
    preorder = [8,5,1,7,10,12]
    solution.bstFromPreorder(preorder)
        
        