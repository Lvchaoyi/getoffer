package linkedlist;

import java.util.Stack;

/*
 * 剑指 Offer 06. 从尾到头打印链表
 * 解法1:通过栈的结构实现一个逆序遍历，时间复杂度O(n)，空间复杂度O(n)
 * 解法2：通过递归，每次调用要求输出上一个节点的只，时间复杂度为O(n)，空间复杂度为O(n)（栈空间）
 * */

public class ReversePrint {
//    解法1
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (!(head == null)) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] reserveList = new int[size];
        for (int i=0; i < size; i ++) {
            reserveList[i] = stack.pop();
        }
        return reserveList;
    }

    public static void main(String[] args) {
        ReversePrint rp = new ReversePrint();
    }
}
