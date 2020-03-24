class MedianFinder(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.nums = []
        self.length = 0

    def addNum(self, num):
        """
        :type num: int
        :rtype: None
        """
        if self.length == 0:
            self.nums.append(num)
            self.length += 1
        else:
            index = self.length-1
            for i in range(self.length):
                if num <= self.nums[i]:
                    index = i
                    break
            self.nums.insert(index, num)
            self.length += 1

    def findMedian(self):
        """
        :rtype: float
        """
        if self.length % 2 != 0:
            return self.nums[int(self.length/2)]
        else:
            return (self.nums[int(self.length/2)] + self.nums[int(self.length/2)-1]) * 0.5

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
if __name__ == '__main__':
    mf = MedianFinder()
    mf.addNum(-1)
    print(mf.findMedian())
    mf.addNum(-2)
    print(mf.findMedian())
    mf.addNum(-3)
    print(mf.findMedian())
    mf.addNum(-4)
    print(mf.findMedian())
    mf.addNum(-5)
    print(mf.nums)
    print(mf.findMedian())
