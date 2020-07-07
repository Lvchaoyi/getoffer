package algorithm.search;

/*
* 剑指 Offer 04. 二维数组中的查找
* 解法1：线性查找（从右上角开始查找，由于数字从上到下，从左到右递增，所以不会错过元素）TODO
* */

class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target > matrix[i][j])
                j ++;
            else if (target < matrix[i][j])
                i --;
            else
                return true;
        }
        return false;
    }

//    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        if (matrix.length == 0 || matrix[0].length == 0)
//            return false;
//        int m = matrix.length, n = matrix[0].length;
//        if (target < matrix[0][0] || target > matrix[m - 1][n - 1])
//            return false;
//        int j = 0;
//        for (int[] ints : matrix) {
//            while (j >= 0 && j < n) {
//                if (ints[j] == target)
//                    return true;
//                else if (j < n - 1 && ints[j] < target && target < ints[j + 1])
//                    break;
//                else if (ints[j] < target)
//                    j ++;
//                else if (ints[j] > target)
//                    j --;
//            }
//            if (j >= n)
//                j = n - 1;
//            else if (j < 0)
//                j = 0;
//        }
//        return false;
//    }

    public static void main(String[] args) {

    }
}
