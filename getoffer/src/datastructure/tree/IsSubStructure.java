package datastructure.tree;

/*
* 剑指 Offer 26. 树的子结构
* 题解1：递归，先序遍历依次匹配节点即可(由于节点的值可能不同，所以不能通过值的相对顺序来判断是否为子结构) TODO
* */

public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
