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
        mid = int(self.length / 2)
        start = 0
        end = self.length - 1
        if self.length == 0:
            self.nums.append(num)
            self.length += 1
        else:
            while start <= end:
                if self.nums[mid] > num and self.nums[mid-1] <= num:
                    self.nums = self.nums[:mid] + num + self.nums[mid:]
                    self.length += 1
                if num > self.nums[mid]:
                    start = mid + 1
                if num < self.nums[mid]:
                    end = mid - 1


    def findMedian(self):
        """
        :rtype: float
        """
        if self.length % 2 != 0:
            return self.nums[int(self.length/2)]
        else:
            return (self.nums[int(self.length/2)] + self.nums[int(self.length/2)+1]) / 2

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
if __name__ == '__main__':
    mf = MedianFinder()
    mf.addNum(1)
    mf.addNum(2)
    mf.addNum(3)
    mf.findMedian()
