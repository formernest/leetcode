# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        count = 0
        max1 = 0
        max2 = 0
        queue = []
        queue.append(root)
        while len(queue) != 0:
            length = len(queue)
            sumtemp = 0
            for i in range(length):
                sumtemp += queue[i].val
                if queue[i].left != None:
                    queue.append(queue[i].left)
                if queue[i].right != None:
                    queue.append(queue[i].right)
            queue = queue[length:]
            if count % 2 == 0:
                max1 += sumtemp
            else:
                max2 += sumtemp
            count += 1
        return max(max1, max2)

if __name__ == "__main__":
    pass
