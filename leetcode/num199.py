# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        if root is None:
            return result
        queue = []
        queue.append(root)
        front = None
        while len(queue) != 0:
            size = len(queue)
            for i in range(size):
                front = queue[0]
                queue.remove(queue[0])
                if front.left != None:
                    queue.append(front.left)
                if front.right != None:
                    queue.append(front.right)
                if i == size-1:
                    result.append(front.val)
        return result
            

        