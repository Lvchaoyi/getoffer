package datastructure.tree;

/*
* 剑指 Offer 55 - II. 平衡二叉树
* 解法1：递归求深度，之后对每一个节点的左右子节点判断深度是否差距小于1（从顶至底，由于求深度需要递归，判断平衡也需要递归，有重复计算，所以时间复杂度为要高一些）
* 解法2：后序遍历+剪枝（从底至顶）TODO
* */

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
