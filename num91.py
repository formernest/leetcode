class Solution:
    def numDecodings(self, s: str) -> int:
        if len(s) == 0:
            return False
        dp = [0 for i in range(len(s)+1)]
        dp[0] = 1
        if s[0] == '0':
            dp[1] = 0
        else:
            dp[1] = 1
        for i in range(2, len(s)+1):
            s1 = int(s[i-1: i])
            s2 = int(s[i-2: i])
            if s2 >= 10 and s2 <= 26:
                dp[i] = dp[i-2]
            if s1 > 0 and s1 <= 9:
                dp[i] += dp[i-1]
        return dp[len(s)]


if __name__ == "__main__":
    s = Solution()
    input = "226"
    print(s.numDecodings(input))
