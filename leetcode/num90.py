from typing import List

class Solution:
    def subsetsWithDup(self, nums: List[int], sorted: bool=False) -> List[List[int]]:
        if not nums:
            return [[]]
        elif len(nums) == 1:
            return [[], nums]
        else:
            if not sorted:
                nums.sort()
            pre_lists = self.subsetsWithDup(nums[:-1], sorted)
            all_lists = [i + [nums[-1]] for i in pre_lists] + pre_lists
            result = []
            for i in all_lists:
                if i not in result:
                    result.append(i)
        return result

        