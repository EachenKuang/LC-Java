package com.eachenkuang.leetcode;

/**
 * @author eachenkuang
 * @date 2022/10/19 09:15
 * @description:
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 *
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 *
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 *
 */
public class Lc367 {

    /**
     * 二分法
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        int left = 1;
        int right = num/2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 14;
        assert !isPerfectSquare(num);
        assert !isPerfectSquare(15);
        assert isPerfectSquare(4);
        assert !isPerfectSquare(-1);
        assert isPerfectSquare(808201);

    }
}
