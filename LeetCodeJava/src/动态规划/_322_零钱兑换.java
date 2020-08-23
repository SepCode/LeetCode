package 动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        //dp[n] = min(dp[n - 1], dp[n - 2], dp[n - 5]) + 1;
        // dp[1] = 1; dp[2] = 1; dp[5] = 1;
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
