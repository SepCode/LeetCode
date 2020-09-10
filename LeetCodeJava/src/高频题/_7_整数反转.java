package 高频题;

public class _7_整数反转 {
    public int reverse(int x) {

        int res = 0;
        while (x != 0) {
            int tmp = res;
            int mod = x % 10;
            res = mod + tmp * 10;
            if (((res - mod) / 10) != tmp) return 0;
            x /= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _7_整数反转().reverse(123));
    }
}
