package 动态规划;

public class _300_最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        //    输入: [10,9,2,5,3,7,101,18]
        //    输出: 4
        //    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
//        T(n) = O(n^2)
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;

    }

    public static void main(String[] args) {
        new _300_最长上升子序列().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }

}
