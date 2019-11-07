class Solution(object):
    def sortArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = []
        counts = [0 for i in range(100001)]
        for num in nums:
            counts[num + 50000] += 1
        for i in range(len(counts)):
            while counts[i]:
                res.append(i - 50000)
                counts[i] -= 1
        return res


if __name__ == '__main__':
    solution = Solution()
    nums = [5, 2, 3, 1]
    print(solution.sortArray(nums))