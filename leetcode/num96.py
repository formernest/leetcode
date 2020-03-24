class Solution(object):
    def numTrees(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0 or n == 1:
            return 1
        F = [0 for _ in range(n+1)]
        F[0] = 1
        F[1] = 1
        for i in range(2, n+1):
            for j in range(1, i+1):
                F[i] += F[j-1] * F[i-j]
        return F[n]

if __name__ == "__main__":
    solution = Solution()
    n = 3
    print(solution.numTrees(n))
