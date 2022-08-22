package com.eachenkuang.suixianglu.stackqueue;

import java.util.Stack;

public class EvalRPN {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int latter = stack.pop();
                int former = stack.pop();
                int result;
                if ("+".equals(token)) {
                    result = former + latter;
                } else if ("-".equals(token)) {
                    result = former - latter;
                } else if ("*".equals(token)) {
                    result = former * latter;
                } else {
                    result = former / latter;
                }
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();

    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        int result = evalRPN(tokens);
        System.out.print(result);
    }
    
}
