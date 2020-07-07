package datastructure.stacknqueue;

/*
* 剑指 Offer 30. 包含min函数的栈
* 解法1：双栈法，一个栈维护正常顺序，另一个栈维护最小元素即可，但凡小于原先的栈顶元素就push即可（诸如{3，2，1，4，5}这样的序也可以处理，因为后面的元素没有小于当前最小值时，pop以后min也不会用到它们）TODO
* 解法2：只用一个栈，正常push和pop，只记录一个最小值即可，唯一的问题是pop最小值时，不确定之后的最小值是多少（解决方案：在push时，先push当前最小值，再push原先最小值）
* */

import java.util.*;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        int temp = stack.pop();
        if (temp == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }



//    自己写的解法，不满足O(1)的时间复杂度
//    LinkedList<Integer> sortList;
//    Stack<Integer> stack;
//
//    public MinStack() {
//        sortList = new LinkedList<>();
//        stack = new Stack<>();
//    }
//
//    public void push(int x) {
//        stack.push(x);
//        if (sortList.size() == 0)
//            sortList.add(x);
//        else {
//            int i = 0;
//            while (i < sortList.size() - 1 && x > sortList.get(i) && x < sortList.get(i + 1))
//                i ++;
//            if (x > sortList.get(i))
//                sortList.add(x);
//            else
//                sortList.add(i, x);
//        }
//
//    }
//
//    public void pop() {
//        Integer temp = stack.pop();
//        sortList.remove(temp);
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int min() {
//        return sortList.getFirst();
//    }

    public static void main(String[] args) {

        MinStack ms = new MinStack();
        ms.push(0);
        ms.push(1);
        ms.push(0);
        System.out.println(ms.minStack);
    }

}
