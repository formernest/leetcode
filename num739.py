class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        dp = [30001 for _ in range(101)]
        res = [0 for _ in range(len(T))]
        for i in range(len(T)-1, -1, -1):
            index = 30001
            for j in range(T[i] + 1, 101):
                if dp[j] < index:
                    index = dp[j]
            if index < 30001:
                res[i] = index - i
            dp[T[i]] = i
        return res
    
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        stack = []
        res = [0 for i in range(len(T))]
        for i in range(len(T)-1, -1, -1):
            while len(stack) != 0 and T[stack[-1]] <= T[i]:
                stack.remove(stack[-1])
            if len(stack) == 0:
                res[i] = 0
            else:
                res[i] = stack[-1] - i
            stack.append(i)
        return res


if __name__ == "__main__":
    T = [89, 62, 70, 58, 47, 47, 46, 76, 100, 70]
    solution = Solution()
    print(solution.dailyTemperatures(T))

