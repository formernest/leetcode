class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for index in range(0, len(nums)):
            if index == 0:
                if index + 1 == len(nums) or nums[index] > nums[index+1]:
                    return index
            elif index == len(nums)-1:
                if nums[index] > nums[index-1]:
                    return index
            elif nums[index] > nums[index-1] and nums[index] > nums[index+1]:
                return index

if __name__ == '__main__':
    nums = [1,2,1,3,5,6,4]
    solution = Solution()
    print(solution.findPeakElement(nums))