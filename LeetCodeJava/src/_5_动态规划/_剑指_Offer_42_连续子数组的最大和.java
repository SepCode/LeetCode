package _5_动态规划;

public class _剑指_Offer_42_连续子数组的最大和 {
    public int maxSubArray(int[] nums) {

        // dp[n] = dp[n - 1] > 0 ? dp[n - 1] + nums[n] : nums[n];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
