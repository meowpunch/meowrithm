class Solution:
    def mySolution(self, prices: List[int]) -> int:
        """
        buy the last(minimum) value in decreasing sequence
        sell the one at the last(maximum) value in increasing sequence
        """
        lastDay = len(prices) - 1
        profit = 0
        buyPrice = prices[0]
        sellPrice = None

        for day in range(1, lastDay + 1):
            price = prices[day]
            # buying
            if not sellPrice and buyPrice > price:
                buyPrice = price
            # selling
            else:
                # update sellPrice
                if not sellPrice or sellPrice <= price:
                    sellPrice = price

                # sell
                if day == lastDay or sellPrice > price:
                    profit += sellPrice - buyPrice
                    buyPrice = price
                    sellPrice = None

        return profit

    def peakValley(self, prices: List[int]) -> int:
        """
        sum of peaks - sum of valleys
        """

        i, peakSum, valleySum = 0, 0, 0

        while i < len(prices):
            # buy
            while i < len(prices) - 1 and prices[i] > prices[i + 1]:
                i += 1
            else:
                valleySum += prices[i]

            # sell
            while i < len(prices) - 1 and prices[i] < prices[i + 1]:
                i += 1
            else:
                peakSum += prices[i]

            i += 1

        return peakSum - valleySum

    def simpleOnePass(self, prices: List[int]) -> int:
        profit = 0

        for i in range(len(prices) - 1):
            if prices[i] < prices[i + 1]:
                profit += prices[i + 1] - prices[i]

        return profit

    def maxProfit(self, prices: List[int]) -> int:
        return self.simpleOnePass(prices)
