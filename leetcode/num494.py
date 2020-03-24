
# class Solution(object):
#     count = 0
#     def findTargetSumWays(self, nums, S):
#         """
#         :type nums: List[int]
#         :type S: int
#         :rtype: int
#         """
#         self.findTargetSum(nums, 0, 0, S)
#         return self.count
      
#     def findTargetSum(self, nums, start, s, S):
#         if start == len(nums):
#             if(s == S):
#                 self.count += 1
#         else:
#             self.findTargetSum(nums, start + 1, s + nums[start], S)
#             self.findTargetSum(nums, start + 1, s - nums[start], S)

class Solution(object):
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        dp = [0 for _ in range(2001)]
        dp[nums[0] + 1000] = 1
        dp[-nums[0] + 1000] += 1
        for i in range(1, len(nums)): 
            next = [0] * 2001
            for sum in range(-1000, 1001):
                if dp[sum + 1000] > 0 :
                    next[sum + nums[i] + 1000] += dp[sum + 1000]
                    next[sum - nums[i] + 1000] += dp[sum + 1000]
            dp = next
        if S > 1000:
            return 0
        else:
            return dp[S+1000]

if __name__ == "__main__":
    nums = [1, 1, 1, 1, 1]
    solution = Solution()
    print(solution.findTargetSumWays(nums, 3))