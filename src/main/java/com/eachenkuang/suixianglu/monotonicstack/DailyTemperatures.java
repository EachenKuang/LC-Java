package com.eachenkuang.suixianglu.monotonicstack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author eachenkuang
 * @date 2022/9/16 16:51
 * @description:
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 */
public class DailyTemperatures {
    /**
     * 暴力法
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 单调栈法
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures2(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[deque.peek()]) {
                deque.push(i);
            } else {
                while(!deque.isEmpty() && temperatures[i]>temperatures[deque.peek()]) {
                    result[deque.peek()] = i - deque.peek();
                    deque.pop();
                }
                deque.push(i);
            }
        }
        return result;
    }

    public static int[] dailyTemperatures3(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while(!deque.isEmpty() && temperatures[i]>temperatures[deque.peek()]) {
                result[deque.peek()] = i - deque.peek();
                deque.pop();
            }
            deque.push(i);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(temperatures);
        int[] result2 = dailyTemperatures2(temperatures);
        int[] result3 = dailyTemperatures3(temperatures);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < result.length; i++) {
            System.out.print(result2[i]);
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < result.length; i++) {
            System.out.print(result3[i]);
            System.out.print(" ");
        }

    }
}
