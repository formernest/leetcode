class Solution:
    def maxProfit(self, prices):
        if prices == []:
            return 0
        num_min = prices[0]
        num_max = 0
        for item in prices:
            num_min = min(num_min, item)
            num_max = max(num_max, item-num_min)
        return num_max


if __name__ == "__main__":
    s = Solution()
    nums = [7,6,4,3,1]
    print(s.maxProfit(nums))
