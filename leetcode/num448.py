class Solution(object):
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        dp = [0 for _ in range(len(nums)+1)]
        for item in nums:
            dp[item] += 1
        for i in range(1, len(nums)+1):
            if dp[i] == 0:
                res.append(i)
        return res


if __name__ == '__main__':
    nums = [4,3,2,7,8,2,3,1]
    solution = Solution()
    print(solution.findDisappearedNumbers(nums))