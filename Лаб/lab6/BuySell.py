def maxProfit(self, prices: list[int]) -> int:
        max_profit = 0
        start = prices[0]
        length = len(prices)

        for i in range(1, length):
            if start < prices[i]:
                max_profit += prices[i] - start
            start = prices[i]

        return max_profit
