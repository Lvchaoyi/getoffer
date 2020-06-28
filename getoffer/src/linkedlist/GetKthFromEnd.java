package linkedlist;

/*
* 剑指 Offer 22. 链表中倒数第k个节点
* 解法1：通过前后双指针（距离为k）来获取倒数第k个节点，时间复杂度为2n-k
* 解法2：先遍历获取指针长度，再遍历n-k次获取倒数第k个节点，时间复杂度为2n-k
* */

public class GetKthFromEnd {
//    解法1
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head;
        ListNode later = head;
        for (int i = 0; i < k-1; i ++) {
            former = former.next;
        }
        while (former.next != null) {
            later = later.next;
            former = former.next;
        }
        return later;
    }
}
