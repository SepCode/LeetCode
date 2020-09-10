package _7_DFS;

import java.util.ArrayList;
import java.util.List;

public class _17_电话号码的字母组合 {
    private char[][] lettersArray = {
            {},{},
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    List<String> list = new ArrayList<>();
    char[] dc;
    public List<String> letterCombinations(String digits) {
        dc = digits.toCharArray();
        if (dc.length == 0) return list;
        char[] str = new char[dc.length];

        dfs(0, str);
        return list;
    }

    private void dfs(Integer idx, char[] str) {
        if (idx == dc.length) {
            list.add(new String(str));
            return;
        }

        for (char c : lettersArray[dc[idx] - '0']) {
            str[idx] = c;
            dfs(idx + 1, str);
        }
    }


}
