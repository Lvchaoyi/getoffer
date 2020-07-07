package algorithm.dp;

/*
* 剑指 Offer 49. 丑数
* 解法1：dp（第n大的丑数是由之前x位的丑数*2，3，5得来的，只需要维持a,b,c三个索引表示第a，b，c位数字乘以2，3，5大于当前丑数即可） TODO
* */

public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0, num = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i ++) {
            int ta = dp[a] * 2, tb = dp[b] * 3, tc = dp[c] * 5;
            dp[i] = Math.min(ta, Math.min(tb, tc));
//            注意++不是互斥的，可以同时对两个索引进行累加
            if (dp[i] == ta) a ++;
            if (dp[i] == tb) b ++;
            if (dp[i] == tc) c ++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        NthUglyNumber n = new NthUglyNumber();
        System.out.println(n.nthUglyNumber(6));
    }
}
