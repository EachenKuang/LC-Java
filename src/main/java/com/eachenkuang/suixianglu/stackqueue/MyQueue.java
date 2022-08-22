package com.eachenkuang.suixianglu.stackqueue;

import java.util.Stack;

/**
 * @author eachenkuang
 * @date 2022/8/22 7:38 PM
 * @description:
 */
public class MyQueue {

    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        if (outputStack.empty()) {
            // 将 input 全部 倒入 output，顺序翻转
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    public int peek() {
        if (outputStack.empty()) {
            // 将 input 全部 倒入 output，顺序翻转
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return outputStack.empty() && inputStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
