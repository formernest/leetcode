class Solution(object):
    def superEggDrop(self, K, N):
        """
        :type K: int
        :type N: int
        :rtype: int
        """
        dp = [[0 for i in range(K+1)] for j in range(N+1)]
        m = 0
        while dp[m][K] < N:
            m += 1
            for k in range(1, K+1):
                dp[m][k] = dp[m-1][k-1] + dp[m-1][k] + 1
        return m


if __name__ == "__main__":
    K = 3
    N = 14
    solution = Solution()
    print(solution.superEggDrop(K, N))