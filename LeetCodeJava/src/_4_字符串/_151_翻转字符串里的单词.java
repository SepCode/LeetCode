package _4_字符串;

public class _151_翻转字符串里的单词 {
    public String reverseWords(String s) {

        if (s == null || s.length() == 0) return s;
        char[] cs = s.toCharArray();

        // 去除多余空格
        int len = removeSpace(cs);
        if (len <= 0) return "";
        // 字符串反转[0,len)
        reverseRange(cs, 0, len);
        // 单词反转
        int l = 0;
        for (int r = 0; r < len; r++) {
            if (cs[r] == ' ') {
                reverseRange(cs, l, r);
                l = r + 1;
            }
        }
        // 处理最后一个单词
        reverseRange(cs, l, len);

        return new String(cs, 0, len);
    }

    private int removeSpace(char[] cs) {
        int cur = 0;
        boolean prevSpace = true;
        for (int i = 0; i < cs.length; i++) {
            char ci = cs[i];
            if (ci != ' ') { // 非空格
                cs[cur] = ci;
                cur++;
                prevSpace = false;
            } else if (!prevSpace){ // 遇到第一个空格
                cs[cur] = ' ';
                cur++;
                prevSpace = true;
            }
        }

        if (prevSpace) cur--;
        return cur;
    }


    private void reverseRange(char[] cs, int l, int r) {
        for (int i = l, j = r - 1; i < j; i++, j--) {
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
        }
    }


    public static void main(String[] args) {
        System.out.println(new _151_翻转字符串里的单词().reverseWords("   hello    world  "));;
    }
}


