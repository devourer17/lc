package arrays;

public class BestTimeToBuyAndSellStockI {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        maxProfitV1(prices);
        maxProfitV2(prices);
    }

    // Time - O(n), Space - O(1)
    private static void maxProfitV1(int[] prices) {
        int min = Integer.MAX_VALUE, profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            if (profit < prices[i] - min)
                profit = prices[i] - min;
        }
        System.out.println(profit);
    }

    // Kadane's Algorithm
    // Similar To 'Max SubArray Problem'
    private static void maxProfitV2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            // Crux Points --> i == 1 & maxCur "+="
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        System.out.println(maxSoFar);
    }
}
