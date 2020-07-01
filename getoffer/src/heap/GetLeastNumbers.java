package heap;

/*
* 剑指 Offer 40. 最小的k个数
* 解法1：快排 TODO
* 解法2：小根堆 TODO
* 解法3：二叉树 TODO
* 解法4：计数排序 TODO
* */

class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0)
            return new int[]{};
        int[] leastNumbers = new int[k];
        int lo = 0, hi = arr.length - 1, index = Integer.MAX_VALUE;
        while (index != k - 1) {
            index = partition(arr, lo, hi);
            if (index > k - 1)
                hi = index - 1;
            else
                lo = index + 1;
        }
        for (int i = 0; i < k; i ++)
            leastNumbers[i] = arr[i];
        return leastNumbers;
    }

    private int partition(int[] arr, int lo, int hi) {
        int seed = arr[lo];
        int i = lo, j = hi + 1, k;
        while (true) {
            while (++i <= hi && arr[i] < seed);
            while (--j >= lo && arr[j] > seed);
            if (i >= j)
                break;
            exchange(arr, i, j);
        }
        exchange(arr, lo, j);
        return j;
    }

    private void exchange(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{3,2,1};
        int[] intss = solution.getLeastNumbers(ints, 2);
        for (int i: intss)
            System.out.println(i);
    }
}
