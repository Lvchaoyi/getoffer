package datastructure.tree;

/*
* 剑指 Offer 27. 二叉树的镜像
* 题解1：对每个节点进行递归（自底向上）
* 题解2：利用辅助栈从根节点进行反转 TODO
* */

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}

