package DFS;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {
    public List<String> generateParenthesis(int n) {

        char[] str = new char[n << 1];
        List<String> list = new ArrayList<>();
        dfs(str, 0, list, n, n);
        return list;
    }

    private void dfs(char[] str, int idx, List<String> list, int leftRemain, int rightRemain) {
        if (str.length == idx) {
            list.add(new String(str));
            return;
        }


        if (leftRemain > 0) {
            str[idx] = '(';
            dfs(str, idx + 1, list, leftRemain - 1, rightRemain);
        }

        if (rightRemain > leftRemain) {
            str[idx] = ')';
            dfs(str, idx + 1, list, leftRemain, rightRemain - 1);
        }

    }
}
