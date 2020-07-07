package datastructure.tree;

/*
* 剑指 Offer 07. 重建二叉树
* 1.解法1 利用前序遍历中序遍历的特性（前序遍历：根节点|左子树|右子树，中序遍历：左子树|根节点|右子树）递归 TODO
* */

import java.util.HashMap;

public class BuildTree {
    private HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i ++)
            map.put(inorder[i], i);
        return buildTree(preorder, 0, 0, inorder.length - 1);
    }

    TreeNode buildTree(int[] preorder, int n, int l, int r) {
        if (n >= preorder.length || l > r)
            return null;
        TreeNode node = new TreeNode(preorder[n]);
        int index = map.get(preorder[n]);
        node.left = buildTree(preorder, n + 1, l, index - 1);
//        右节点的位置是确定的，因为左子树的长度已经确定为在中序遍历中为index - l + 1
        node.right = buildTree(preorder, n + index - l + 1, index + 1 , r);
        return node;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(new int[]{1,2,3}, new int[]{3,2,1});
    }
}
