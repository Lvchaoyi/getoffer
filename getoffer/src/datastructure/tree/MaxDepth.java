package datastructure.tree;

/*
* 剑指 Offer 55 - I. 二叉树的深度
* 解法1：递归，后序遍历 TODO
* 解法2：bfs层序遍历
* */

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
