package 动态规划;

public class _面试题_08_11_硬币 {
    public int waysToChange(int n) {
//
//              0   1   2   3   4   5   6
//        1     1   1   1   1   1   1   1
//        5     1   1   1   1   1   2   2
//        10    1   1   1   1   1   2   2
//        25    1   1   1   1   1   2   2

        int[] coins = new int[]{1, 5, 10, 25};
        int[][] dp = new int[coins.length + 1][n + 1];

        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = (dp[i][j - coins[i - 1]] + dp[i - 1][j]) % 1000000007;
                } else {
                    dp[i][j] = dp[i - 1][j] % 1000000007;
                }
            }
        }
        return dp[coins.length][n];
    }
}
