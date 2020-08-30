package 动态规划;

public class _674_最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {

        if (nums.length <= 1) return nums.length;
        int dp = 1, max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp = dp + 1;
                max = Math.max(max, dp);
            } else  {
                dp = 1;
            }
        }
        return max;
    }
}
