package _7_DFS;

public class _463_岛屿的周长 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {

                    r = dfs(grid, i, j);
                }
            }
        }
        return r;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (outArea(grid, row, col)) return 1;

        if (grid[row][col] == 0) return 1;
        if (grid[row][col] == 2) return 0;

        grid[row][col] = 2;
        return dfs(grid, row + 1, col) +
                dfs(grid, row - 1, col) +
                dfs(grid, row, col + 1) +
                dfs(grid, row, col - 1);
    }

    private boolean outArea(int[][] grid, int row, int col) {
        return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length;
    }
}
