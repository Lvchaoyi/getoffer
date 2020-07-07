package algorithm.dp;

/*
* 剑指 Offer 42. 连续子数组的最大和
* 解法1：dp（以i结尾的最大子数组和）TODO
* */

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            nums[i] += nums[i - 1] > 0 ? nums[i - 1] : 0;
            if (max < nums[i])
                max = nums[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{8,-19,5,-4,20}));
    }
}
