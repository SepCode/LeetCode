package _4_字符串;

public class _242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        int[] sc = new int[128];

        for (int i = 0; i < cs.length; i++) {
            sc[cs[i]]++;
        }

        for (int i = 0; i < ct.length; i++) {
            if (--sc[ct[i]] < 0) return false;
        }
        return true;
    }
}
