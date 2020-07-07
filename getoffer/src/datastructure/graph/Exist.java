package datastructure.graph;

/*
* 剑指 Offer 12. 矩阵中的路径
* 解法1：dfs加上回溯即可 TODO
* */

public class Exist {


    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (dfs(board, word.toCharArray(), i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][]board, char[] words, int i, int j, int k) {
        if (!(i >= 0 && j >= 0 && i < board.length && j < board[0].length) || board[i][j] != words[k]) {
            return false;
        }
        if (k == words.length - 1)
            return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean match = dfs(board, words, i + 1, j, k + 1) ||
                dfs(board, words, i - 1, j, k + 1) ||
                dfs(board, words, i, j + 1, k + 1) ||
                dfs(board, words, i, j - 1, k + 1);
        board[i][j] = tmp;
        return match;
    }


//    变量太多，可以简化
//    private int m;
//    private int n;
//    private int length;
//    private char[] words;
//    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//    private boolean[][] marked;
//
//
//    public boolean exist(char[][] board, String word) {
//        m = board.length;
//        n = board[0].length;
//        length = word.length();
//        words = word.toCharArray();
//        marked = new boolean[m][n];
//        for (int i = 0; i < m; i ++) {
//            for (int j = 0; j < n; j ++) {
//                if (dfs(board, i, j, 0))
//                    return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean dfs(char[][] board, int i, int j, int count) {
//        if (board[i][j] == words[count]) {
//            if (count == length - 1)
//                return true;
//            marked[i][j] = true;
//            for (int[] direction: directions) {
//                int newRow = i + direction[0];
//                int newCol = j + direction[1];
//                if (inRange(newRow, newCol) && !marked[newRow][newCol] && dfs(board, newRow, newCol, count + 1)) {
//                    return true;
//                }
//            }
//            marked[i][j] = false;
//        }
//        return false;
//    }
//
//    private boolean inRange(int i, int j) {
//        return i >= 0 && i < m && j >=0 && j < n;
//    }

    public static void main(String[] args) {
        Exist exist = new Exist();
        char[][] c = {{'a', 'b'}, {'c', 'd'}};
        boolean b = exist.exist(c, "abcd");
        System.out.println(b);
    }
}
