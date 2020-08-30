package 动态规划;
//输入: [2,3,2]
//        输出: 3
//        解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
public class _213_打家劫舍_II {
    public int rob(int[] nums) {

        //      6
        //    1   5
        //  2       4
        //      3
        // dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        // 打劫第一间或者不打劫
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        int max = dp[nums.length - 1];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return Math.max(max, dp[nums.length - 2]);
    }
}
