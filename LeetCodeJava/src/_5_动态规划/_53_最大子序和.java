package _5_动态规划;

public class _53_最大子序和 {



    public int maxSubArray(int[] nums) {

        int dp = 0;
        int sum = nums[0];
        for (int num : nums) {

            dp = dp > 0 ? dp + num : num; // tmp > 0 表示加上cur还是正收益，目的是为了加上下一个更大的收益

            sum = Math.max(sum, dp);
        }
        return sum;
    }


    public int maxSubArray1(int[] nums) {

        int sum = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = sum;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            dp[i] = Math.max(dp[i - 1] + cur, cur);
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }
}
