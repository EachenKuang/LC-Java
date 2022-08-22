package com.eachenkuang.suixianglu.stackqueue;

import java.util.Stack;

/**
 * @author eachenkuang
 * @date 2022/8/22 8:06 PM
 * @description:
 */
public class IsValid {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ')':
                case '}':
                case ']':
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.print(isValid(s));
    }
}
