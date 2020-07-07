package datastructure.tree;

/*
* 剑指 Offer 33. 二叉搜索树的后序遍历序列
* 题解1：递归（对每个节点判断是否为后序遍历即可）
* 题解2：辅助单调栈 TODO
* */

public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int l, int r) {
        if (l >= r)
            return true;
        int le = r - 1;
        for (int i = l; i < r; i ++) {
            if (postorder[i] > postorder[r]) {
                le = i - 1;
                break;
            }
        }
        for (int i = le + 1; i < r; i ++) {
            if (postorder[i] < postorder[r]) {
                return false;
            }
        }
        if (le == r)
            return recur(postorder, le + 1, r - 1);
        else
            return recur(postorder, l, le) && recur(postorder, le + 1, r - 1);
    }

    public static void main(String[] args) {
        new VerifyPostorder().verifyPostorder(new int[]{1, 2, 3, 4, 5});
    }
}
