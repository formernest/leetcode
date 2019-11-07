class RLEIterator(object):
    array = []
    index = 0
    def __init__(self, A):
        """
        :type A: List[int]
        """
        self.array = A

    def next(self, n):
        """
        :type n: int
        :rtype: int
        """
        while self.index < len(self.array) and self.array[self.index]-n < 0:
            n -= self.array[self.index]
            self.index += 2
        if self.index >= len(self.array):
            return -1
        self.array[self.index] -= n
        return self.array[self.index + 1]
        
if __name__ == "__main__":
    rle = RLEIterator([3,8,0,9,2,5])
    nextarray = [2, 1, 1, 2]
    for item in nextarray:
        print(rle.next(item))

# Your RLEIterator object will be instantiated and called as such:
# obj = RLEIterator(A)
# param_1 = obj.next(n)