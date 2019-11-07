class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        k = 0
        size = len(nums)
        for i in range(size):
            if nums[i] == 0:
                k += 1
            else:
                nums[i - k] = nums[i]
        while k > 0:
            nums[size-k] = 0
            k -= 1
        return nums

if __name__ == "__main__":
    nums = [0,1,0,3,12]
    solution = Solution()
    print(solution.moveZeroes(nums))