package 动态规划;

public class _122_买卖股票的最佳时机_II {
    public int maxProfit(int[] prices) {

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i] - prices[i - 1];
            if (price > 0) {
                max += price;
            }
        }
        return max;
    }
}
