package linkedlist;

import java.util.HashMap;
/*
* 剑指 Offer 35. 复杂链表的复制
* 解法1：通过hash表记录每个节点对应的新节点，不管是next还是random只要根据hash表中的对应关系即可找到相应节点，时间复杂度为O(n)，额外空间复杂度为O(n)
* 解法2：拆解链表，每个节点和下一个节点之间通过新节点连接，本质上和hasp表原理类似，但是不需要hash表的额外空间 TODO
* */

public class CopyRandomList {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            hm.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node node = hm.get(cur);
            node.next = hm.get(cur.next);
            node.random = hm.get(cur.random);
            cur = cur.next;
        }
        return hm.get(head);
    }

//    主要通过数组下标来记录对应的random节点
//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return head;
//        }
//        ArrayList<Integer> oldValList = new ArrayList<>();
//        ArrayList<Integer> randomIndexList = new ArrayList<>();
//        ArrayList<Node> nodeList = new ArrayList<>();
//
//        Node cur = head;
//        Integer randomIndex = 0;
//        int index = 0;
//        while (cur != null) {
//            oldValList.add(cur.val);
//            cur.val = index;
//            index ++;
//            cur = cur.next;
//        }
//        cur = head;
//        while (cur != null) {
//            randomIndex = cur.random != null ? cur.random.val: null;
//            randomIndexList.add(randomIndex);
//            cur = cur.next;
//        }
//        for (int i = 0; i < index; i ++) {
//            Node node = new Node(i);
//            nodeList.add(node);
//        }
//        for (int i = 0; i < index; i ++) {
//            Node node = nodeList.get(i);
//            node.val = oldValList.get(i);
//            randomIndex = randomIndexList.get(i);
//            node.random = randomIndex != null ? nodeList.get(randomIndex) : null;
//            if (i >= 1) {
//                nodeList.get(i - 1).next = node;
//            }
//        }
//        return nodeList.get(0);
//    }
}
