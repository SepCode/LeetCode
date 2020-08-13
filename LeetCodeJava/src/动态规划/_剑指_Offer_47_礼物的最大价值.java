package 动态规划;

public class _剑指_Offer_47_礼物的最大价值 {
    public int maxValue(int[][] grid) {

//        输入:
//                [
//                  [1,3,1],
//                  [1,5,1],
//                  [4,2,1]
//                ]
//        输出: 12
//        解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

        // dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        int row = grid.length + 1;
        int col = grid[0].length + 1;

        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }


    public static void main(String[] args) {
        new  _剑指_Offer_47_礼物的最大价值().maxValue(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
}
