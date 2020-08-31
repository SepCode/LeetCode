package 动态规划;

public class _123_买卖股票的最佳时机_III {
    public int maxProfit(int[] prices) {
        // 穷举状态
        // dp[i][k][0 or 1]
        // i 天 k 交易完成（买卖）次数 0 未持有 1 持有
        // dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        // dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
        //
        // dp[i][0][0] = 0;
        // dp[i][0][1] = min;

        // k <= 2

        if (prices == null || prices.length <= 1) return 0;

        int k = 2;
        int[][][] dp = new int[prices.length][k + 1][2];
//        dp[0][0][0] = 0;
//        dp[0][1][0] = 0;
//        dp[0][1][1] = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                 dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                 dp[i][j][1] = Math.max(dp[i - 1][j][1], (dp[i - 1][j - 1][0] - prices[i]));
            }
        }
        return dp[prices.length - 1][k][0];
    }

    public static void main(String[] args) {
        new _123_买卖股票的最佳时机_III().maxProfit(new int[]{1,2,3,4,5});
    }
}
