package arrays;

public class BestTimeToBuyAndSellStockII {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        maxProfit(prices);
    }

    // Time - O(n), Space - O(1)
    private static void maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        }
        System.out.println(profit);
    }


    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solutions/1569081/java-simple-clean-dp-solutions-for-all-6-buy-sell-stock-questions-on-leetcode
}
