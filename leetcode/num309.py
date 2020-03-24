class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) <= 1:
            return 0
        buy = [-1 for i in range(len(prices))]
        sell = [-1 for i in range(len(prices))]
        buy[0] = -prices[0]
        buy[1] = max(-prices[0], -prices[1])
        sell[0] = 0
        sell[1] = max(prices[1] - prices[0], 0)
        for i in range(2, len(prices)):
            # 可以是buy或者cooldown
            buy[i] = max(buy[i-1], sell[i-2] - prices[i])
            # 可以是sell或者cooldown
            sell[i] = max(buy[i-1] + prices[i], sell[i-1])
        return max(buy[len(prices)-1], sell[len(prices)-1], 0)

if __name__ == "__main__":
    prices = [1,2,3,0,2]
    solution = Solution()
    print(solution.maxProfit(prices))
    

