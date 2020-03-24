class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length == 0:
            return 0
        dp = [0 for i in range(len(nums)+1)]
        dp[1] = nums[0]
        for i in range(2, len(nums)+1):
            dp[i] = max(dp[i-1], nums[i-1] + dp[i-2])
        return dp[len(nums)]


if __name__ == "__main__":
    nums = [2,7,9,3,1]
    solution = Solution()
    print(solution.rob(nums))
