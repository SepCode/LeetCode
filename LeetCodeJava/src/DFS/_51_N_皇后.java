package DFS;

import java.util.ArrayList;
import java.util.List;

public class _51_N_皇后 {

    List<List<String>> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {


        int[] cols = new int[n];
        dfs(0, cols);
        return list;
    }

    private void dfs(int row, int[] cols) {
        if (row == cols.length) {
            List<String> sub = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                char[] str = new char[cols.length];
                for (int j = 0; j < cols.length; j++) {
                    str[j] = cols[i] == j ? 'Q' : '.';
                }
                sub.add(new String(str));
            }
            list.add(sub);
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
