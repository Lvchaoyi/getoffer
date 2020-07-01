package stacknqueue;

import java.util.Stack;

/*
* 剑指 Offer 09. 用两个栈实现队列 TODO
* 解法1：双栈法，一个栈负责进，一个栈负责出，值在
* */

public class CQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public CQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (in.isEmpty() && out.isEmpty())
            return -1;
        if (out.isEmpty()) {
            while (in.size() > 1)
                out.push(in.pop());
//            避免了一进一出时的pop两次的操作
            return in.pop();
        }
        return out.pop();
    }

//    out栈往in栈回倒的步骤是多余的
//    public int deleteHead() {
//        if (in.size() == 0)
//            return -1;
//        else {
//            while (!in.isEmpty())
//                out.push(in.pop());
//        }
//        int head = out.pop();
//        while (!out.isEmpty())
//            in.push(out.pop());
//        return head;
//    }

}
