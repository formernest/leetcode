# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def constructFromPrePost(self, pre, post):
        """
        :type pre: List[int]
        :type post: List[int]
        :rtype: TreeNode
        """
        if len(pre) == 0:
            return None
        root = TreeNode(pre[0])
        if len(pre) == 1:
            return root
        index = post.index(pre[1])
        root.left = self.constructFromPrePost(pre[1:index+2], post[:index+1])
        root.right = self.constructFromPrePost(pre[index+2:], post[index+1:-1])
        return root
