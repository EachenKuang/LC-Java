package com.eachenkuang.swordoffer;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *
 *
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 *
 * @author eachenkuang
 * @date 2022/2/13 4:34 下午
 * @description:
 */
public class Sword10 {

    private final static int mode = 1000000007;

    /**
     * 递归方法
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int first = fib(n-1) % mode;
        int second = fib(n-2) % mode;
        return (first + second) % mode;
    }

    /**
     * 备忘录
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 1;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = f1 + f2;
            f1 = f2 % mode;
            f2 = temp % mode;
        }
        return f2;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.print(fib2(n));
    }
}
