package algorithm.sort;

/*
* 剑指 Offer 51. 数组中的逆序对
* 解法1：归并，统计归并数组中的逆序次数 TODO
* */

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return merge(nums, 0, nums.length - 1);
    }

    int merge(int[] arr, int left, int right) {
        if (right <= left)
            return 0;
        int mid = left + (right - left) / 2, count = 0;
        count += merge(arr, left, mid) + merge(arr, mid + 1, right);
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            count += arr[i] <= arr[j] ? j - mid - 1 : 0;
            tmp[k ++] = arr[i] <= arr[j] ? arr[i ++] : arr[j ++];
        }
        while (j <= right)
            tmp[k ++] = arr[j ++];
        while (i <= mid) {
            count += j - mid - 1;
            tmp[k ++] = arr[i ++];
        }
        System.arraycopy(tmp, 0, arr, left, right - left + 1);
        return count;
    }

    public static void main(String[] args) {
//        System.arraycopy(new int[]{1, 2}, 0, new int[]{1,2,3,4}, 2, 3);
        int[] ints = new int[]{3, 1};
        System.out.println(new ReversePairs().merge(ints, 0, 1));
        for (int i: ints)
            System.out.println(i);
    }
}
