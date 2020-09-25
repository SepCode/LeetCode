package _7_DFS;

public class _200_岛屿数量 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    r++;
                    dfs(grid, i, j);
                }
            }
        }
        return r;

    }

    public void dfs(char[][] grid, int row, int col) {
        if (outArea(grid, row, col)) return;

        if (grid[row][col] != '1') return;

        grid[row][col] = '2';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    private boolean outArea(char[][] grid, int row, int col) {
        return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length;
    }


}
