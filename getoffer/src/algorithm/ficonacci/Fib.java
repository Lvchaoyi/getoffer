package algorithm.ficonacci;

/*
* 剑指 Offer 10- I. 斐波那契数列
* 解法1：DP动态规划（循环求余即可），时间复杂度O(n)，空间复杂度O(1)
* 解法2：递归法+记忆法
* */

public class Fib {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i ++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
//    解法2
//    private HashMap<Integer, Integer> dic = new HashMap();
//    {
//        dic.put(0, 0);
//        dic.put(1, 1);
//    }
//    public int fib(int n) {
//        if (dic.containsKey(n))
//            return dic.get(n);
//        int result = fib(n - 1) + fib(n - 2);
//        if (result > 1e9+7)
//            result %= 1e9+7;
//        dic.put(n, result);
//        return result;
//    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(5));
    }
}
