package 动态规划;

public class _72_编辑距离 {
    public int minDistance(String word1, String word2) {

//        插入一个字符
//        删除一个字符
//        替换一个字符
//              a   b   f
//        a
//        b
//        c


        // !=
        // dp[row][col] = dp[row - 1][col - 1] + 1; 替换
        // dp[row][col] = dp[row - 1][col] + 1; 删除
        // dp[row][col] = dp[row][col - 1] + 1; 插入
        // ==
        // dp[row][col] = dp[row - 1][col - 1]; 相等

        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        int row = c1.length + 1;
        int col = c2.length + 1;

        int[][] dp = new int[row][col];

        for (int i = 1; i < row; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}
