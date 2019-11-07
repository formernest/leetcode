
class Solution(object):
    count = 0
    # def findTargetSumWays(self, nums, S):
    #     """
    #     :type nums: List[int]
    #     :type S: int
    #     :rtype: int
    #     """
    #     self.findTargetSum(nums, 0, 0, S)
    #     return self.count
    def findTargetSumWays(self, nums, S):
        dp = [[ for col in range(2001)] for row in range(len(nums))]
        self.findTargetSum(nums, 0, 0, S, dp)
        return dp[len(nums)-1][S+1000]


    def findTargetSum(self, nums, start, s, S, dp):
        if start == len(nums):
            if s == S:
                return 1
            else:
                return 0
        else:
            dp[start][s+1000] += dp[]
            self.findTargetSum(nums, start + 1, s + nums[start], S, dp)
            self.findTargetSum(nums, start + 1, s - nums[start], S, dp)
      
    # def findTargetSum(self, nums, start, s, S):
    #     if start == len(nums):
    #         if(s == S):
    #             self.count += 1
    #     else:
    #         self.findTargetSum(nums, start + 1, s + nums[start], S)
    #         self.findTargetSum(nums, start + 1, s - nums[start], S)


if __name__ == "__main__":
    nums = [27,22,39,22,40,32,44,45,46,8,8,21,27,8,11,29,16,15,41,0]
    solution = Solution()
    print(solution.findTargetSumWays(nums, 10))