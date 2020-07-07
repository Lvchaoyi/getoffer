package algorithm.search;

/*
* 剑指 Offer 56 - I. 数组中数字出现的次数
* 解法1：分组异或位运算 TODO
* */

public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int result = 0, diff = 0, k = 1, single1 = 0, single2 = 0;
        for (int num: nums)
            result ^= num;
        while (result != 1) {
            result >>= 1;
            diff ++;
        }
        for (int n = diff; n > 0; n --)
            k *= 2;
        for (int num: nums) {
            if ((num & k) == 0)
                single1 ^= num;
            else
                single2 ^= num;
        }
        return new int[]{single1, single2};

    }

    public static void main(String[] args) {
        SingleNumbers sn = new SingleNumbers();
        int[] ints = sn.singleNumbers(new int[]{4,1,4,6});
        for (int i: ints)
            System.out.println(i);
    }
}
