# Definition for a binary tree node.
from TreeNode import Tree
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if t1 == None:
            return t2
        if t2 == None:
            return t1
        t1.val += t2.val
        t1.left = self.mergeTrees(t1.left, t2.left)
        t1.right = self.mergeTrees(t1.right, t2.right)
        return t1


if __name__ == "__main__":
    tree = Tree()
    nums1 = [1, 3, 2, 5]
    nums2 = [2, 1, 3, None, 4, None, 7]
    t1 = tree.creatTree(nums1)
    t2 = tree.creatTree(nums2)
    tree.print_Tree(t1)
    tree.print_Tree(t2)  
    solution = Solution()
    root = solution.mergeTrees(t1, t2)
    tree.print_Tree(root)
    




        