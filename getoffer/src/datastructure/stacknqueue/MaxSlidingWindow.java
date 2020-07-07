package datastructure.stacknqueue;

/*
* 剑指 Offer 59 - I. 滑动窗口的最大值 TODO
* 解法1：双指针移动，确保队列中的数字是非严格递减（即剔除所有小于入列数字的数），则队列首个数字是最大值，每次输出该值即可
* */

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[]{};
        Deque<Integer> deque = new LinkedList<>();
        int[] maxList = new int[nums.length - k + 1];
        for (int i = 1 - k, j = 0; j < nums.length; i ++, j ++) {
            System.out.println(deque);
            if (i > 0 && nums[i - 1] == deque.peekFirst())
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() <= nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            if (j >= k - 1)
                maxList[j - k + 1] = deque.getFirst();
        }
        for (int i: maxList)
            System.out.println(i);
        return maxList;
    }

//    少了一个指针，内部的循环有可能存在重复遍历的情况
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length == 0 || k == 0)
//            return new int[]{};
//        LinkedList<Integer> window = new LinkedList<>();
//        int[] max = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length; i ++) {
//            int num = nums[i];
//            if (window.size() > 0 && num >= window.get(0)) {
//                window.clear();
//                window.add(num);
//            } else if (window.size() == k) {
//                window.add(num);
//                window.remove(0);
//                int maxIndex = 0;
//                for (int j = 1; j < k; j ++) {
//                    if (window.get(j) >= window.get(maxIndex))
//                            maxIndex = j;
//                }
//                if (maxIndex > 0) {
//                    window.subList(0, maxIndex).clear();
//                }
//            } else
//                window.add(num);
//            if (i >= k - 1) {
//                max[i - k + 1] = window.get(0);
//
//            }
//        }
//        for (int i: max)
//            System.out.println(i);
//        return max;
//    }

    public static void main(String[] args) {
        MaxSlidingWindow msw = new MaxSlidingWindow();
        int[] ints = new int[]{1,3,1,2,0,5};
        msw.maxSlidingWindow(ints, 3);
    }
}
