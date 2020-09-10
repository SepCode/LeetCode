package _4_字符串;

public class _3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {

        // 1, 1, 3, 1, 5, 6
        // ⬆
        // li

        if (s == null || s.length() == 0) return 0;
        char[] cs = s.toCharArray();
        int[] numbs = new int[128];
        int len = 1, li = 0;
        for (int i = 0; i < cs.length; i++) {

            if (li < numbs[cs[i]]) {
                li = numbs[cs[i]];
            }

            numbs[cs[i]] = i + 1;
            len = Math.max(len, i - li + 1);
        }
        return len;
    }
}
