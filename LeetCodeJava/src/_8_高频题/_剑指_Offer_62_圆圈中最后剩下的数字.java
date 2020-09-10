package _8_高频题;

public class _剑指_Offer_62_圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {

        if (n == 0) return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    }
}
