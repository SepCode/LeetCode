package 动态规划;

public class _188_买卖股票的最佳时机_IV {
    public int maxProfit(int k, int[] prices) {

        // 穷举状态
        // dp[i][k][0 or 1]
        // i 天 k 交易完成（买卖）次数 0 未持有 1 持有
        // dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        // dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
        //
        // dp[i][0][0] = 0;
        // dp[i][0][1] = min;

        if (k == 0 || prices.length <= 1) return 0;
        // k 太大导致可以随便买卖
        if (k > (prices.length >> 1)) return maxProfit(prices);

        int[][][] dp = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }

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
