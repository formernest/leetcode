class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = [1] + nums + [1]
        size = len(nums)
        dp =[[0 for col in range(size)] for row in range(size)]
        for length in range(1, size-1):
            for start in range(1, size-length):
                end = start + length - 1
                for k in range(start, end+1):
                    dp[start][end] = max(dp[start][end], nums[start-1] * nums[k] * nums[end+1] + dp[start][k-1] + dp[k+1][end])
        return dp[1][size-2]

        
if __name__ == "__main__":
    nums = [3, 1, 5, 8]
    solution = Solution()
    print(solution.maxCoins(nums))