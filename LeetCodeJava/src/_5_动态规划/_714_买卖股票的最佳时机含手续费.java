package _5_动态规划;

public class _714_买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {

        // 穷举状态
        // dp[i][k][0 or 1]
        // i 天 k 交易完成（买卖）次数 0 未持有 1 持有
        // dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        // dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
        //
        // k = max
        // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        // dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);

        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i] - fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[prices.length - 1][0];
    }
}
