package datastructure.tree;

/*
* 剑指 Offer 32 - I. 从上到下打印二叉树
* 剑指 Offer 32 - II. 从上到下打印二叉树
* 剑指 Offer 32 - III. 从上到下打印二叉树 （可分奇偶，也可使用双端队列 TODO）
* 解法1：bfs+队列即可
* */

import java.util.*;

public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            order.add(node.val);
            if (node.left != null ) queue.add(node.left);
            if (node.right != null ) queue.add(node.right);
        }
        int[] levelOrder = new int[order.size()];
//        注意不能用size为判断条件的同时移除元素
        for (int j = 0; j < order.size(); j ++) {
            levelOrder[j] = order.get(j);
        }
        return levelOrder;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> orders = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        if (root == null)
            return orders;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            ArrayList<Integer> order = new ArrayList<>();
            for (int i = 0; i < queue.size(); i ++) {
                TreeNode node = queue.get(i);
                order.add(node.val);
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            Collections.reverse(order);
            orders.add(order);
            queue = tmp;
        }
        return orders;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        boolean reversed = false;
        List<TreeNode> queue = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> order = new ArrayList<>();
            List<TreeNode> tmp = new ArrayList<>();
            for (int i = 0; i < queue.size(); i ++) {
                TreeNode node = queue.get(i);
                order.add(node.val);
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            if (reversed) {
                Collections.reverse(order);
                reversed = false;
            }
            else
                reversed = true;
            res.add(order);
            queue = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode right = new TreeNode(20);
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        root.left = new TreeNode(9);
        root.right = right;
        LevelOrder levelOrder = new LevelOrder();
        levelOrder.levelOrder(root);
    }

}
