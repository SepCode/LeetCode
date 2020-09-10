package _5_动态规划;

public class _70_爬楼梯 {
    public int climbStairs(int n) {

        if (n <= 2) return n;

        // dp[n] = dp[n - 1] + dp[n - 2];
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 2) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
