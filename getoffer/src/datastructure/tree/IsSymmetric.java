package datastructure.tree;

/*
* 剑指 Offer 28. 对称的二叉树
* 题解1：递归即可（对根节点开始进行递归是不够的，需要对左右两个子节点进行递归） TODO
* 题解2：bfs+翻转链表(煞笔解法)
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IsSymmetric {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return recur(root.left, root.right);
        }

        boolean recur(TreeNode l, TreeNode r) {
            if (l == null && r == null) return true;
            if (l == null || r == null || l.val != r.val) return false;
            return recur(l.left, r.right) && recur(l.right, r.left);
        }


//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        List<TreeNode> level = new ArrayList<>();
//        level.add(root);
//        while (!isEmpty(level)) {
//            List<TreeNode> tmp = new ArrayList<>();
//            List<TreeNode> reLevel = new ArrayList<>(level);
//            Collections.reverse(level);
//            for (int i = 0; i < level.size(); i ++) {
//                TreeNode node = level.get(i);
//                TreeNode reNode = reLevel.get(i);
//                if (!((node == null && reNode == null) || (node != null && reNode != null && node.val == reNode.val)))
//                    return false;
//                tmp.add(node != null ? node.left: null);
//                tmp.add(node != null ? node.right: null);
//            }
//            level = tmp;
//        }
//        return true;
//    }
//
//    boolean isEmpty(List<TreeNode> list) {
//        for (TreeNode node: list) {
//            if (node != null)
//                return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        new IsSymmetric().isSymmetric(new TreeNode(0));
    }
}
