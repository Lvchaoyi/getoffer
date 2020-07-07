package datastructure.tree;

/*
* 剑指 Offer 34. 二叉树中和为某一值的路径（注意读题，路径是需要遍历到叶子节点的，中间的子树根节点是不算的）
* 题解1：dfs+递归(注意LinkedList比ArrayList效率高多了，因为涉及到添加删除操作,以及固定的数不应该设置为参数，如sum)
* */

import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class PathSum {
    private List<List<Integer>> paths = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) {
            LinkedList<Integer> path = new LinkedList<>();
            dfs(root, sum, path);
        }
        return paths;
    }

    void dfs(TreeNode root, int tar, LinkedList<Integer>path) {
        if (root == null)
            return;
        path.add(root.val);
        tar -= root.val;
        if (0 == tar && root.left == null && root.right == null) {
//            Java中是引用传递，形参是对应了地址的，所以应该用深拷贝，而新版本的Java支持初始化深拷贝
            paths.add(new LinkedList<>(path));
        }
        dfs(root.left, tar, path);
        dfs(root.right, tar, path);
        path.removeLast();
        return;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        new PathSum().pathSum(root, 1);
    }
}
