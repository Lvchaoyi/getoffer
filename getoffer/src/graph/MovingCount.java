package graph;

/*
* 剑指 Offer 13. 机器人的运动范围
* 解法1：bfs（和后者的区别在于每次都是对同一层级的数据进行遍历，而不是在一个for循环中能够直接走到底，所以一般用队列存储当前的同一层级节点） TODO
* 解法2：dfs
* */

import java.util.LinkedList;

public class MovingCount {

    public int movingCount(int m, int n, int k) {
        LinkedList<int []> queue = new LinkedList<>();
        boolean [][] marked = new boolean[m][n];
        int count = 0;
        queue.add(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0], j = point[1], si = point[2], sj = point[3];
            if (!(i >= 0 && i < m && j >= 0 && j < n && k >= si + sj && !marked[i][j]))
                continue;
            count += 1;
            marked[i][j] = true;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return count;
    }


//    注意dfs和bfs的区别
//    private int row;
//    private int col;
//    private int limit;
//    private boolean[][] marked;
//
//    public int movingCount(int m, int n, int k) {
//        row = m;
//        col = n;
//        limit = k;
//        marked = new boolean[m][n];
//        int count = 0;
//        dfs(0, 0);
//        for (int i = 0; i < m; i ++) {
//            for (int j = 0; j < n; j ++) {
//                if (marked[i][j])
//                    count += 1;
//            }
//        }
//        return count;
//    }
//
//    private void dfs(int i, int j) {
//        if (!(i >= 0 && i < row && j >= 0 && j < col && !marked[i][j] && getSum(i) + getSum(j) <= limit))
//            return;
//        marked[i][j] = true;
//        dfs(i + 1, j);
//        dfs(i, j + 1);
//    }
//
//    private int getSum(int n) {
//        int sum = 0;
//        while (n >= 10) {
//            sum += n % 10;
//            n /= 10;
//        }
//        sum += n;
//        return sum;
//    }

    public static void main(String[] args) {
        MovingCount mc = new MovingCount();
        System.out.println(mc.movingCount(10, 10, 1));
    }
}
