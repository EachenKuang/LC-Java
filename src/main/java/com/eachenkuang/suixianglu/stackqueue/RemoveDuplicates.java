package com.eachenkuang.suixianglu.stackqueue;

import java.util.Stack;

/**
 * @author eachenkuang
 * @date 2022/8/22 8:22 PM
 * @description:
 */
public class RemoveDuplicates {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()
             ) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else if(stack.peek() == c) {
                stack.pop();
            }
        }

        StringBuilder str = new StringBuilder();
        //剩余的元素即为不重复的元素
        while (!stack.isEmpty()) {
            str.insert(0, stack.pop());
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "aabbcab";
        System.out.print(removeDuplicates(s));
    }
}
