package com.eachenkuang.suixianglu.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author eachenkuang
 * @date 2022/8/22 7:47 PM
 * @description:
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindow {

    /**
     * 是用长度为K的队列来保存
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length + 1 - k];
        MyQueue1 queue = new MyQueue1();
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        result[0] = queue.front();
        for (int i = k, j = 1; i < result.length; i++, j++) {
            queue.pop(nums[i-k]);
            queue.push(nums[i]);
            result[j] = queue.front();
        }
        return result;
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
    
}

class MyQueue1 {
    
    Deque<Integer> deque;

    public MyQueue1() {
        deque = new LinkedList<>();
    }

    public void pop(int value) {
        if (front() == value) {
            deque.removeFirst();
        }
    }

    public void push(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.removeLast();
        }
        deque.add(value);
    }

    public int front() {
        return deque.peekFirst();
    }
}
