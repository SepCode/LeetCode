package _5_动态规划;
//        输入：[1,2,3,1]
//        输出：4
//        解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/house-robber
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _198_打家劫舍 {
    public int rob(int[] nums) {

        // 选或不选
        // dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}
