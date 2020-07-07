package algorithm.bitwise;

/*
* 剑指 Offer 16. 数值的整数次方
* 解法1：通过位运算把时间复杂度降低为O(lgn)，tips：大数的计算可以用位运算避免重复计算 TODO
* */

public class MyPow {
    public double myPow(double x, int n) {
        long m = Math.abs((long)n);
        double res = 1.0;
        if (n < 0) {
            x = 1 / x;
        }
        while (m > 0) {
            if ((m & 1) == 1)
                res *= x;
            x *= x;
            m >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new MyPow().myPow(2.00000, -2147483648);
    }
}
