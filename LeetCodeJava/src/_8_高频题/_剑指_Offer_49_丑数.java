package _8_高频题;

public class _剑指_Offer_49_丑数 {
    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[p2] * 2, n3 = dp[p3] * 3, n5 = dp[p5] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2) p2++;
            if (dp[i] == n3) p3++;
            if (dp[i] == n5) p5++;
        }
        return dp[n - 1];
    }
}
