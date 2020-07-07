package datastructure.stacknqueue;

/*
* 剑指 Offer 31. 栈的压入、弹出序列
* 解法1：通过辅助栈来的实际操作来校验push和pop的正确性，类似于括号的匹配
* */

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack stack = new Stack<>();
        int i = 0;
        for (int num: pushed) {
            stack.push(num);
            while (!stack.isEmpty() && (int)stack.peek() == popped[i]) {
                stack.pop();
                i ++;
            }
        }
        return stack.isEmpty();
    }

//    指针i其实可以省略
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack stack = new Stack<>();
//        int i= 0, j = 0;
//        while (j < popped.length) {
//            if (stack.size() > 0 && (int)stack.peek() == popped[j]) {
//                stack.pop();
//                j ++;
//            } else if (i < pushed.length) {
//                stack.push(pushed[i]);
//                i ++;
//            } else {
//                break;
//            }
//        }
//        if (stack.isEmpty())
//            return true;
//        return false;
//    }

    public static void main(String[] args) {
        ValidateStackSequences vss = new ValidateStackSequences();
        int[] ints1 = new int[]{1, 2, 3, 4, 5};
        int[] ints2 = new int[]{4,3,5,1,2};
        vss.validateStackSequences(ints1, ints2);
    }

}
