package datastructure.tree;

/*
* 剑指 Offer 36. 二叉搜索树与双向链表
* 解法1：递归，（看到二叉搜索树，就想到中序遍历，就想到dfs） TODO
* */

import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class TreeToDoublyList {

    private Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        dfs(root);
        head.right = pre;
        pre.left = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null)
            return;
        dfs(cur.left);
        if (pre == null)
            head = cur;
        else
            pre.right = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
//    中序遍历只需要保存上一个节点即可，递归可以形成整个链表，不需要存两个节点
//    public Node treeToDoublyList(Node root) {
//        List<Node> res = recur(root);
//        Node left = res.get(0);
//        Node right = res.get(0);
//        if (left != null && right != null) {
//            left.left = right;
//            right.right = left;
//        }
//        return left;
//    }
//
//    List<Node> recur(Node root) {
//
//        List<Node> res = new ArrayList<>();
//        res.add(root);
//        res.add(root);
//        if (root == null)
//            return res;
//        List<Node> lres = recur(root.left);
//        List<Node> rres = recur(root.right);
//        root.left = lres.get(1);
//        root.right = rres.get(0);
//        if (root.right != null) {
//            root.right.left = root;
//            res.set(1, rres.get(1));
//        }
//        if (root.left != null) {
//            root.left.right = root;
//            res.set(0, lres.get(0));
//        }
//        System.out.println(res);
//        return res;
//    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        new TreeToDoublyList().treeToDoublyList(root);
    }
}
