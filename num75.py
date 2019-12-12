class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        red = 0
        blue = len(nums)-1
        for i in range(0, blue+1):
            if nums[i] == 0:
                print('change i and red', i, red)
                tmp = nums[i]
                nums[i] = nums[red]
                nums[red] = tmp
                red += 1
                
            elif nums[i] == 2:
                print('change i and blue', i, blue)
                tmp = nums[i]
                nums[i] = nums[blue]
                nums[blue] = tmp
                i = i-1
                blue -= 1
                
            print(red, blue, nums)

if __name__ == "__main__":
    nums = [2,0,2,1,1,0]
    solution = Solution()
    solution.sortColors(nums)
    # print(nums)

