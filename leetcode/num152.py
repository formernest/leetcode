import sys
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res, dp_max, dp_min = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            t_max, t_min = dp_max, dp_min
            dp_max = max(t_max*nums[i], t_min*nums[i], nums[i])
            dp_min = min(t_max*nums[i], t_min*nums[i], nums[i])
            res = max(dp_max, res)
        return res


if __name__ == "__main__":
    solution = Solution()
    nums = [2, 3, -2, 4]
    print(solution.maxProduct(nums))