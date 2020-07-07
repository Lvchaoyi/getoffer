package datastructure.linkedlist;

/*
* 剑指 Offer 18. 删除链表的节点
* 解法1：依次遍历链表即可
* */

public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val)
            return head.next;
        ListNode cur = head.next, last = head;
        while (cur != null && cur.val != val) {
//            while中如果有return的话，可以把return的条件放在while循环条件中减少代码量
            last = cur;
            cur = cur.next;
        }
        if (cur != null)
            last.next = cur.next;
        return head;
    }
}
