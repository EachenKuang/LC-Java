package com.eachenkuang.suixianglu.stackqueue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author eachenkuang
 * @date 2022/8/22 7:47 PM
 * @description:
 *
 * 两种方法：
 * 1、使用两个队列
 * 2、使用一个队列
 *  pop 需要 pop n-1 次，然后将 这 n-1 个数 push 回去，再 pop一次
 */
public class MyStack {

    Queue<Integer> queue1; // 和栈中保持一样元素的队列
    Queue<Integer> queue2; // 辅助队列

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x); // 先放在辅助队列中
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp; // 最后交换queue1和queue2，将元素都放到queue1中
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll(); // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
