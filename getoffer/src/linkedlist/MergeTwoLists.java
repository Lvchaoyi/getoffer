package linkedlist;

/*
* 剑指 Offer 25. 合并两个排序的链表
* 解法1：同时遍历链表，进行类似归并排序的组合，每次挑选一个较小的数即可
* 解法2：递归
* */

public class MergeTwoLists {

//    解法1
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode guard = new ListNode(0), cur = guard;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return guard.next;
    }
//    自己写的代码，条件分割得不够好
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode temp, head;
//        ListNode last = null;
//        if (l1 == null && l2 == null) {
//            return null;
//        } else if (l1 != null && l2 == null) {
//            head = l1;
//        } else if (l1 == null) {
//            head = l2;
//        } else {
//            head = (l1.val <= l2.val) ? l1 : l2;
//        }
//        while (l1 != null || l2 != null) {
//            if (l1 != null && l2 != null) {
//                if (l1.val == l2.val) {
//                    temp = l1.next;
//                    l1.next = l2;
//                    if (last != null) {
//                        last.next = l1;
//                    }
//                    last = l2;
//                    l1 = temp;
//                    l2 = l2.next;
//                } else if (l1.val > l2.val) {
//                    if (last != null) {
//                        last.next = l2;
//                    }
//                    last = l2;
//                    l2 = l2.next;
//                } else {
//                    if (last != null) {
//                        last.next = l1;
//                    }
//                    last = l1;
//                    l1 = l1.next;
//                }
//            } else if (l1 == null) {
//                if (last != null) {
//                    last.next = l2;
//                }
//                break;
//            } else {
//                if (last != null) {
//                    last.next = l1;
//                }
//                break;
//            }
//        }
//        return head;
//    }

    public static void main(String[] args) {
        MergeTwoLists mtl  = new MergeTwoLists();
    }
}
