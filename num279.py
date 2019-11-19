class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [float('inf') for _ in range(n+1)]
        dp[0] = 0
        for i in range(0, n+1):
            j = 1
            while i + j * j <= n:
                dp[i + j * j] = min(dp[i] + 1, dp[i+j*j])
                j += 1
        return dp[n]

if __name__ == "__main__":
    solution = Solution()
    n = 13
    print(solution.numSquares(n))