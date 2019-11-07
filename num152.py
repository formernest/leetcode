class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = [1] + nums + [1]
        size = len(nums)
        dp =[[1 for col in range(size)] for row in range(size)]
        for length in range(1, size-1):
            for start in range(1, size - length):
                end = start + length - 1
                for k in range(start, end + 1):
                    dp[start][end] = max(nums[k], dp[start][k-1]*nums[k]*dp[k+1][end], dp[start][k-1], dp[k+1][end])
        return dp[1][size-2]


if __name__ == "__main__":
    solution = Solution()
    nums = [2, 3, -2, 4]
    print(solution.maxProduct(nums))