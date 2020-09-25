package _5_动态规划;

import java.util.ArrayList;
import java.util.List;

public class _面试题_快手_1 {

    public List<Integer> findK(int[] nums) {

        List<Integer> list = new ArrayList<>();
        // dp[n] = max(dp[n], dp[n - 1])
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1], nums[i]);
        }

        int l = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[l]) {
                l = i;
                if (nums[i] < dp[i + 1]) {
                    list.add(nums[i]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        for (int i :
                new _面试题_快手_1().findK(new int[]{4,3,2,7,8,10,9})) {
            System.out.println(i);
        }
    }
}
