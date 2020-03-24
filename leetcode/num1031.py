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
        length = len(A) + 1
        dpsum = [0 for i in range(length)]
        maxL = [0 for i in range(length)]
        maxM = [0 for i in range(length)]
        summax = [0 for i in range(length)]
        for i in range(1, length):
            dpsum[i] = sum(A[:i])
            if i >= L:
                maxL[i] = max(maxL[i-1], dpsum[i] - dpsum[i-L])
            if i >= M:
                maxM[i] = max(maxM[i-1], dpsum[i] - dpsum[i-M])
            if i >= M+L:
                summax[i] = max(summax[i-1], maxL[i-M] + dpsum[i] - dpsum[i-M], maxM[i-L] + dpsum[i] - dpsum[i-L])
        print(dpsum)
        print(maxL)
        print(maxM)
        print(summax)
        return summax[length - 1]

if __name__ == "__main__":
    A = [2,1,5,6,0,9,5,0,3,8]
    L, M = 4, 3
    solution = Solution()
    print(solution.maxSumTwoNoOverlap(A, L, M))
            

        