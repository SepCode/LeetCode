package 动态规划;

public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {

//        输入: [7,1,5,3,6,4]
//        输出: 5
//        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//        注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

        // 转换为最大子串和
        // dp[i] = profit[i] + dp[i - 1]

        // 穷举状态
        // dp[i][k][0 or 1]
        // i 天 k 交易完成（买卖）次数 0 未持有 1 持有
        // dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
        // dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);

        if (prices == null || prices.length <= 1) return 0;
        int[] nums = new int[prices.length - 1];
        int sum = 0, dp = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            nums[i] = prices[i + 1] - prices[i];

            dp = dp > 0 ? dp + nums[i] : nums[i];
            sum = Math.max(sum, dp);
        }

        return sum;
    }
}
