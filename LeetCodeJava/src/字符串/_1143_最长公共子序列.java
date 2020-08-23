package 字符串;

public class _1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
//              a   b   c   e   d
//        f     0   0   0   0   0
//        b     0   1   1   1   1
//        c     0   1   2   2   2
//        d     0   1   2   2   3
//        g     0   1   2   2   3



        //dp[i][j] = c1[i - 1] == c2[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);

        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int[][] dp = new int[c1.length + 1][c2.length + 1];

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                dp[i][j] = c1[i - 1] == c2[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[c1.length][c2.length];


    }
}
