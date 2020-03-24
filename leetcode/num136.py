class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # 异或运算
        a = 0
        for num in nums:
            a = a ^ num
        return a

if __name__ == "__main__":
    solution = Solution()
    nums = [2, 2, 1]
    print(solution.singleNumber(nums))