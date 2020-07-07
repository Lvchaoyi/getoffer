package datastructure.linkedlist;

/*
* 剑指 Offer 52. 两个链表的第一个公共节点
* 解法1：双指针法，两个指针同时移动，一方触底后从另一条链表开始移动，可以确保两个指针同步 TODO
* 解法2：统计长度法，确定链表的长度差，然后确保两个节点是同步移动的
* 解法3：通过集合去重的特性，获取第一个共同的节点
* */

public class GetIntersectionNode {

//    解法1
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode curA = headA, curB = headB;
        int count = 0;
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
            if (curA == null) {
                curA = headB;
                count ++;
            }
            if (curB == null) {
                curB = headA;
                count ++;
            }
            if (count > 2) {
                return null;
            }
        }
        return curA;
    }

//    解法3
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode curA = headA, curB = headB;
//        HashSet<ListNode> hs = new HashSet<>();
//        while (curA != null) {
//            hs.add(curA);
//            curA = curA.next;
//        }
//        while (curB != null) {
//            if (hs.contains(curB)) {
//                return curB;
//            }
//            curB = curB.next;
//        }
//        return null;
//    }

//    解法2
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode curA = headA, curB = headB;
//        int lenA = 1, lenB = 1;
//        while (curA.next != null) {
//            curA = curA.next;
//            lenA ++;
//        }
//        while (curB.next != null) {
//            curB = curB.next;
//            lenB ++;
//        }
//        if (curA != curB) {
//            return null;
//        }
//        curA = headA;
//        curB = headB;
//        if (lenA > lenB) {
//            for (int i = 0; i < lenA - lenB; i ++) {
//                curA = curA.next;
//            }
//        } else {
//            for (int i = 0; i < lenB - lenA; i ++) {
//                curB = curB.next;
//            }
//        }
//        while (curA != null) {
//            if (curA == curB) {
//                return curA;
//            }
//            curA = curA.next;
//            curB = curB.next;
//        }
//        return null;
//    }
}
