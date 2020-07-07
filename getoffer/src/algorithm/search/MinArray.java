package algorithm.search;

/*
* 剑指 Offer 11. 旋转数组的最小数字
* 解法1：二分查找，通过中位数字和右侧数字不断比较缩小范围 TODO
* 解法2：遍历即可
* */

class MinArray {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1, m;
        while (i < j) {
            m = (i + j) / 2;
            if (numbers[m] > numbers[j])
                i = m + 1;
            else if (numbers[m] < numbers[j])
                j = m;
            else
                j --;
        }
        return numbers[i];
    }
}