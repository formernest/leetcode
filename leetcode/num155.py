class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = float('inf')
        
    def push(self, x):
        """
        :type x: int
        :rtype: None
        """
        if x < self.min:
            self.min = x
        self.stack.append(x)

    def pop(self):
        """
        :rtype: None
        """
        temp = self.stack.pop()
        if temp == self.min and len(self.stack) != 0:
            self.min = min(self.stack)
        else:
            self.min = float('inf')

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        
    def getMin(self):
        """
        :rtype: int
        """
        return self.min
        
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
if __name__ == "__main__":
    minStack = MinStack()
    minStack.push(2147483646)
    print(minStack.stack)
    minStack.push(2147483646)
    print(minStack.stack)
    minStack.push(2147483647)
    print(minStack.stack)
    print(minStack.top())
    minStack.pop()
    print(minStack.stack)
    print(minStack.getMin())
    minStack.pop()
    print(minStack.stack)
    print(minStack.getMin())
    print(minStack.top())
    minStack.pop()
    print(minStack.stack)
    minStack.push(2147483647)
    print(minStack.stack)
    print(minStack.top())
    print(minStack.getMin())
    minStack.push(-2147483648)
    print(minStack.stack)
    print(minStack.top())
    print(minStack.getMin())
    minStack.pop()
    print(minStack.stack)
    print(minStack.getMin())
