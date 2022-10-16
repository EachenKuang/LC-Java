package com.eachenkuang.leetcode;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
示例 1:

输入: num = 38
输出: 2 
解释: 各位相加的过程为：
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
由于 2 是一位数，所以返回 2。
 */
public class Lc258 {

    /**
     * 模拟法
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        int result = num;
        while (result >= 10) {
            int temp = 0;
            while (result > 0) {
                temp += result % 10;
                result /= 10;
            }
            result = temp;
        }
        return result;
    }

    /**
     * 数学分析法
     * @param num
     * @return
     */
    public static int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        int num = 49;
        System.out.print(addDigits((num)));
    }
}
