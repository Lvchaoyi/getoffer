package algorithm.bitwise;

/*
* 剑指 Offer 15. 二进制中1的个数
* 解法1：位运算+右移（注意负数和无符号右移操作）
* */

public class HammingWeight {
    public int hammingWeight(int n) {
        int weight = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                weight ++;
            }
            n >>>= 1;
        }
        return weight;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(7));
    }
}
