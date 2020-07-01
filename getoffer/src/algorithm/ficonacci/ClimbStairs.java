package algorithm.ficonacci;

/*
* 剑指 Offer 10- II. 青蛙跳台阶问题 TODO
* 解法1 DP
* */

class Solution {
    public int numWays(int n) {
        int a = 1, b = 2, sum;
        for (int i = 0; i < n - 1 ; i ++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWays(3));
        solution.numWays(2);
    }
}
