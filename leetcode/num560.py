class Solution(object):
    # def subarraySum(self, nums, k):
    #     """
    #     :type nums: List[int]
    #     :type k: int
    #     :rtype: int
    #     """
    #     s = 0
    #     count = 0
    #     length = len(nums)
    #     for start in range(0, length):
    #         s = 0
    #         for end in range(start, length):
    #             s += nums[end]
    #             if s == k:
    #                 count += 1
    #     return count
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        s = 0
        count = 0
        res = {}
        res[0] = 1
        for i in range(0, len(nums)):
            s += nums[i]
            if s-k in res.keys():
                count += res[s-k]
            if s in res.keys():
                res[s] += 1
            else:
                res[s] = 1
        return count


if __name__ == "__main__":
    nums = [-92,-63,75,-86,-58,22,31,-16,-66,-67,420]
    k = 100
    solution = Solution()
    print(solution.subarraySum(nums, k))
