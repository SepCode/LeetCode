package _5_动态规划;

import java.util.Arrays;

public class _300_最长上升子序列 {


    //  牌堆法2 二分
    public int lengthOfLIS(int[] nums) {
        //    输入: [10,9,2,5,3,7,101,18]
        //    输出: 4
        //    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
//        T(n) = O(n^2)
        if (nums.length <= 1) return nums.length;

        int[] heap = new int[nums.length];
        int len = 1;
        heap[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int begin = 0;
            int end = len;
            while (begin < end) {
                int mid = (begin + end) >> 1;
                if (nums[i] <= heap[mid]) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            }
            len = Math.max(len, begin + 1);
            heap[begin] = nums[i];
        }

        return len;

    }

    //  牌堆法1 二分
    public int lengthOfLIS4(int[] nums) {
        //    输入: [10,9,2,5,3,7,101,18]
        //    输出: 4
        //    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
//        T(n) = O(n^2)
        if (nums.length <= 1) return nums.length;

        int[] heap = new int[nums.length];
        Arrays.fill(heap, Integer.MAX_VALUE);

        int len = 1;
        heap[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int begin = 0;
            int end = len;
            while (begin < end) {
                int mid = (begin + end) >> 1;
                if (nums[i] > heap[mid]) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }
            len = Math.max(len, begin);
            heap[begin] = nums[i];
        }

        return len;

    }


//  牌堆法1
    public int lengthOfLIS3(int[] nums) {
        //    输入: [10,9,2,5,3,7,101,18]
        //    输出: 4
        //    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
//        T(n) = O(n^2)
        if (nums.length <= 1) return nums.length;

        int[] heap = new int[nums.length];
        Arrays.fill(heap, Integer.MAX_VALUE);

        int len = 1;
        heap[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int j = 0;
            while (nums[i] > heap[j]) {
                j++;
            }
            len = Math.max(len, j + 1);
            heap[j] = nums[i];
        }

        return len;

    }

    //  牌堆法2
    public int lengthOfLIS2(int[] nums) {
        //    输入: [10,9,2,5,3,7,101,18]
        //    输出: 4
        //    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
//        T(n) = O(n^2)
        if (nums.length <= 1) return nums.length;

        int[] heap = new int[nums.length];
        int len = 1;
        heap[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int j = 0;
            while (j < len) {
                if (nums[i] <= heap[j]) {
                    break;
                }
                j++;
            }
            len = Math.max(len, j + 1);
            heap[j] = nums[i];
        }

        return len;

    }





    // 动态规划
    public int lengthOfLIS1(int[] nums) {
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
