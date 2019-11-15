
class Solution:
    def removeDuplicates(self, nums):
        left = 0
        right = 0
        while(right < len(nums)):
            if(nums[right] == nums[left]):
                right += 1
            else:
                left += 1
                nums[left] = nums[right]
        return right+1


if __name__ == "__main__":
    nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    s = Solution()
    print(s.removeDuplicates(nums))
