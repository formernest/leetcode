class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Tree():
    def creatTree(self, nums):
        if len(nums) == 0:
            return None
        root = TreeNode(nums[0])
        stack = [root]
        for i in range(1, len(nums), 2):
            if nums[i] != None:
                left = TreeNode(nums[i])
            else:
                left = None
            if i+1 < len(nums) and nums[i+1] != None:
                right = TreeNode(nums[i+1])
            else:
                right = None
            peek = stack.pop()
            peek.left = left
            peek.right = right
            stack.append(peek.right)
            stack.append(peek.right)
        return root

    def print_Tree(self, root):
        if root == None:
            return []
        result = []
        queue = []
        queue.append(root)
        while len(queue) != 0:
            peek = queue.pop()
            if peek == None:
                if len(queue) != 0:
                    result.append(None)
            else:
                result.append(peek.val)
                if peek.right != None or peek.left != None:
                    queue.append(peek.right)
                    queue.append(peek.left)
        print(result)
        return result
        

if __name__ == "__main__":
    tree = Tree()
    nums = [1, 3, 2, 5]
    root = tree.creatTree(nums)
    tree.print_Tree(root) 

            

