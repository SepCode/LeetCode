package _8_高频题;

public class _50_Pow_x_n_ {

    // 迭代
    public double myPow(double x, int n) {

        boolean neg = n < 0;
        long y = neg ? -(long)n : n;
        double value = 1.0;
        while (y > 0) {

            if ((y & 1) == 1) {
                value *= x;
            }

            x *= x;
            y >>= 1;
        }

        return neg ? 1 / value : value;
    }

    // 递归
    public double myPow1(double x, int n) {

        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        double half = myPow1(x, n >> 1);
        half *= half;
        return (n & 1) == 0 ? half : half * x;
    }
}
