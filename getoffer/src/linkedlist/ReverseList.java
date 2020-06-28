package linkedlist;

/*
* 剑指 Offer 24. 反转链表
* 解法1：递归（注意递归条件,每次递归调用时可以直接返回尾节点，但是有相应的指针拆分操作即可）
* 解法2：栈
* */

import java.util.Stack;

public class ReverseList {
//    解法1
//    之前自己写的递归代码
//    public ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode tail = head;
//        while (tail.next != null) {
//            tail = tail.next;
//        }
//        reverse(head);
//        head.next = null;
//        return tail;
//    }
//
//    ListNode reverse(ListNode node) {
//        if (node == null) {
//            return null;
//        } else if (node.next == null) {
//            return node;
//        } else {
//            ListNode last = reverse(node.next);
//            last.next = node;
//            return node;
//        }
//    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        ReverseList rl = new ReverseList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode head = rl.reverseList(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
