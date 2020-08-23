package 动态规划;

public class _5_最长回文子串 {


    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        char[] cs = s.toCharArray();
        int i = 0, max = 1, begin = 0;
        while (i < cs.length) {
            int l = i - 1;
            int r = i + 1;
            while (r < cs.length && cs[i] == cs[r]) r++;
            i = r;

            while ( l >= 0 && r < cs.length && cs[l] == cs[r]) {
                l--;
                r++;
            }
            l++;
            if (max < r - l) {
                max = r - l;
                begin = l;
            }
        }
        return s.substring(begin, begin + max);
    }

//    dp
    public String longestPalindrome2(String s) {
//              a   b   a   b
//        a     1   0   1   0
//        b         1   0   1
//        a             1   0
//        b                 1
//
//        dp[row][col] = dp[row + 1][col - 1] && s[row] == s[col];

        if (s == null || s.length() < 2) return s;

        char[] cs = s.toCharArray();
        int row = cs.length;
        int col = row;
        boolean[][] dp = new boolean[row][col];

        for (int i = 0; i < cs.length; i++) {
            dp[i][i] = true;
        }

        int max = 1, l = 0;
        for (int i = row - 2; i >= 0; i--) {
            for (int j = i + 1; j < cs.length; j++) {
                boolean isP = false;
                if (j - i <= 2) {
                    isP = cs[i] == cs[j];
                } else {
                    isP = dp[i + 1][j - 1] && cs[i] == cs[j];
                }
                dp[i][j] = isP;
                int len = j - i + 1;
                if (isP && len >= max) {
                    max = len;
                    l = i;
                }
            }
        }

        return s.substring(l, l + max);

    }


//  暴力
    public String longestPalindrome1(String s) {

        if (s == null || s.length() <= 1) return s;
        char[] cs = s.toCharArray();
        int max = 1, l = 0;

        for (int i = 0; i < cs.length; i++) {
            for (int j = i + 2; j <= cs.length; j++) {
                if (isPalindrome(cs, i, j)) {
                    int len = j - i;
                    if (len > max) {
                        max = len;
                        l = i;
                    }
                }
            }
        }
        return s.substring(l, l + max);

    }
    // 0 1 2 1 0
    // 0 1 2 3 4
    private boolean isPalindrome(char[] cs, int l, int r) {
        while (l < r) {
            if (cs[l++] != cs[--r]) return false;
        }
        return true;
    }
}
