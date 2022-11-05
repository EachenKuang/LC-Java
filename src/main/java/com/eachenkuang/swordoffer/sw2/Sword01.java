package com.eachenkuang.swordoffer.sw2;

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
注意：

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31−1]。本题中，如果除法结果溢出，则返回 231 − 1
 

示例 1：

输入：a = 15, b = 2
输出：7
解释：15/2 = truncate(7.5) = 7
示例 2：

输入：a = 7, b = -3
输出：-2
解释：7/-3 = truncate(-2.33333..) = -2
示例 3：

输入：a = 0, b = 1
输出：0
示例 4：

输入：a = 1, b = 1
输出：1

链接：https://leetcode.cn/problems/xoh6Oh
 */
public class Sword01 {
    /**
     * 题目要求不得使用乘法和除法以及求余，所以需要使用位运算来进行计算
     * @param a
     * @param b
     * @return
     */
    public int divide(int a, int b) {
        int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE, MIN_LIMIT = MIN >> 1; // -1073741824
        if(a == MIN && b == -1) return MAX; // 特判
        boolean isPos = (a < 0 && b > 0) || (a > 0 && b < 0) ? false : true;
        if(a > 0) a = -a;
        if(b > 0) b = -b;
        int ans = 0; // 最终的商
        while(a <= b) {
            int d = b, c = 1; // d为当前除数，c为当前商
            while(d >= MIN_LIMIT && d + d >= a) { // 通过第一个条件防止d + d溢出
                d += d; // 当前除数倍增，也可以用 d <<= 1;
                c += c; // 当前商倍增，也可以用 c <<= 1;
            } 
            a -= d; // a剩余部分
            ans += c; // 累计当前商
        }
        return isPos ? ans : -ans;
    }

    private static final int BOUND = Integer.MIN_VALUE >> 1;

    /**
     * @param dividend 被除数
     * @param divisor  除数
     * @return int
     */
    public int divide2(int dividend, int divisor) {
        // int 型整数的除法只有一种情况会导致溢出，即（-2^31）/(-1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 特殊情况，无需计算，直接返回
        if (dividend == 0 || divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return -dividend;
        }
        // 由于（-2^31） 转换为正数会溢出，但是任意正数转换为负数都不会溢出
        // 故，记录负数的个数，并将正数转换为负数方便统一计算
        int negative = 2;
        if (dividend > 0) {
            negative--;
            // 将 dividend 置为负
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            // 将 divisor 置为负
            divisor = -divisor;
        }
        int result = divideCore(dividend, divisor);
        // 如果负数的个数是 1 个，结果为负；否则，结果为正
        return negative == 1 ? -result : result;
    }

    private int divideCore(int dividend, int divisor) {
        // 被除数 == 除数，直接返回结果为 1
        if (dividend == divisor) {
            return 1;
        }
        // 开始正式计算
        int result = 0;
        int shift = getMaxShift(divisor, dividend);
        while (dividend <= divisor) {
            while (dividend > (divisor << shift)) {
                shift--;
            }
            dividend -= (divisor << shift);
            result += (1 << shift);
        }
        return result;
    }

    private int getMaxShift(int num, int min) {
        // num 是除数，min 是被除数，希望找到 num << shift < min 时，shift 的最大值
        int shift = 0;
        int temp = num;
        while (temp > min && temp >= BOUND) {
            temp <<= 1;
            shift++;
        }
        return shift;
    }

    /**
     * 使用位运行计算两数之和
     * 异或得到(0,1) (0,0)的相加之和，保留在原位置
     * 且运算得到需要进位(1,1)的和，然后左移一位，表示进位
     * 循环计算，知道进位为0，则直接返回和
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1; // Java中右移需要>>>
        return getSum(sum, carry);
    }
}