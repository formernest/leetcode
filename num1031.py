class Solution(object):
    def maxSumTwoNoOverlap(self, A, L, M):
        """
        :type A: List[int]
        :type L: int
        :type M: int
        :rtype: int
        """
        if L + M == len(A):
            return sum(A)
        dp = [0 for i in range(len(A))]
        dp[L+M-1] = sum(A[:L+M])
        for i in range(L+M, len(A)):
            dp[i] = max(dp[i-1], )
        