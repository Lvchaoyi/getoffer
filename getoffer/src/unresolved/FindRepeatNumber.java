package unresolved;

import java.util.HashSet;

/*
* 剑指 Offer 03. 数组中重复的数字
*
* 解法1:集合，时间复杂度O(n)，空间复杂度O(n)
* 解法2:hash地址（本身整数的值）对应数组下标，时间复杂度O(n)，空间复杂度O(1)
* 解法3:排序后，依次进行比较，时间复杂度O(nlgn)，空间复杂度O(1)
*  */

public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
//        解法1
        HashSet<Integer> hs =  new HashSet<>();
        for (int num: nums) {
            if (!hs.add(num)) {
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int[] nums = {1, 3, 3};
        int repeatNumber = findRepeatNumber.findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }
}
