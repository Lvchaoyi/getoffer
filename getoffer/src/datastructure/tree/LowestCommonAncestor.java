package datastructure.tree;

/*
* 剑指 Offer 68 - II. 二叉树的最近公共祖先
* 题解1：递归并求最近祖先
* 题解2：dfs求路径后再比较（傻逼方法）
* */

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null)
            return left;
        if (right != null)
            return right;
        return root;
    }

//    这样的dfs只能输出路径，多了进行比较的步骤
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        TreeNode[] pArray = new TreeNode[1000];
//        TreeNode[] qArray = new TreeNode[1000];
//        dfs(pArray, root, p, 0);
//        dfs(qArray, root, q, 0);
//        for (int i = 1; i < qArray.length; i ++) {
//            System.out.println(qArray[i] != null ? qArray[i].val: null);
//            System.out.println(pArray[i] != null ? pArray[i].val: null);
//            if (qArray[i] != pArray[i])
//                return qArray[i - 1];
//        }
//        return null;
//    }
//
//    boolean dfs(TreeNode[] arr, TreeNode root, TreeNode target, int level) {
//        if (root == null) {
//            return false;
//        }
//        if (root.val  == target.val) {
//            arr[level] = root;
//            return true;
//        } else {
//            if (dfs(arr, root.left, target, level + 1)) {
//                arr[level] = root;
//                return true;
//            }
//            if (dfs(arr, root.right, target, level + 1)) {
//                arr[level] = root;
//                return true;
//            }
//        }
//        return false;
//    }
}
