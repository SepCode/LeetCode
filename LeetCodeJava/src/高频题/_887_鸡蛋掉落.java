package 高频题;

public class _887_鸡蛋掉落 {
    public int superEggDrop(int K, int N) {
        // K 鸡蛋 N 楼层
        // 使用第i个鸡蛋，第j次扔鸡蛋，可以确定的层数 f(i, j)，在第f(i - 1, j - 1) + 1层测试
        // i被扔出后两种结果：碎 or 没碎
        // 总层数： f(i, j) = f(i - 1, j - 1) + 1    +    f(i, j - 1)
        //
        // dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + 1;


        int[][] dp = new int[K + 1][N + 1];
        int j = 0;
        while (dp[K][j] < N) {
            j++;
            for (int i = 1; i <= K; i++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + 1;
            }
        }

        return j;
    }
}
