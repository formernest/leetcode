def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        self.findTargetSum(nums, 0, 0, S)
        return self.count