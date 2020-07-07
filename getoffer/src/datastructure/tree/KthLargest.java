package datastructure.tree;

/*
* 剑指 Offer 54. 二叉搜索树的第k大节点
* 题解1：逆序中序遍历+剪枝提前返回 TODO
* */

public class KthLargest {
    private int res, cur;
    public int kthLargest(TreeNode root, int k) {
        this.cur = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (cur == 0) return;
        if (-- cur == 0) res = root.val;
        dfs(root.left);
    }

//    没有剪枝，没有逆序
//    public int kthLargest(TreeNode root, int k) {
//        List<Integer>order = lastOrder(root);
//        return order.get(order.size() - k);
//    }
//
//    List<Integer> lastOrder(TreeNode root) {
//        List<Integer> last = new ArrayList<>();
//        if (root == null) return last;
//        last.addAll(lastOrder(root.left));
//        last.add(root.val);
//        last.addAll(lastOrder(root.right));
//        return last;
//    }
}
