class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        nums = sorted(nums)
        max_len = 1
        cur_len = 1
        for i in range(1, len(nums)):
            if nums[i] != nums[i-1]:
                if nums[i] == nums[i-1] + 1:
                    cur_len += 1
                else:
                    max_len = max(max_len, cur_len)
                    cur_len = 1
        return max(max_len, cur_len)

if __name__ == "__main__":
    nums = [0, -1]
    solution = Solution()
    print(solution.longestConsecutive(nums))