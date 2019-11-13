class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        dp = [0 for _ in range(length+1)]
        for item in nums:
            dp[item] += 1
            if dp[item] > 1:
                return item

if __name__ == "__main__":
    solution = Solution()
    nums = [1,3,4,2,2]
    print(solution.findDuplicate(nums))