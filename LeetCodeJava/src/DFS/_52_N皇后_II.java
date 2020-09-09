package DFS;

public class _52_N皇后_II {

    int way = 0;
    public int totalNQueens(int n) {

        int[] cols = new int[n];
        dfs(0, cols);
        return way;
    }

    private void dfs(int row, int[] cols) {
        if (row == cols.length) {
            way++;
            return;
        }

        for (int i = 0; i < cols.length; i++) {
            if (isValid(i, row, cols)) {
                cols[row] = i;
                dfs(row + 1, cols);
            }

        }
    }

    private boolean isValid(int col, int row, int[] cols) {
        for (int j = 0; j < row; j++) {
            if (cols[j] == col) return false;
            if (Math.abs(col - cols[j]) == row - j) return false;
        }
        return true;
    }
}
