package com.eachenkuang.leetcode;

/*
你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。

给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。

 

示例 1：
输入：n = 5
输出：2
解释：因为第三行不完整，所以返回 2 。
示例 2：


输入：n = 8
输出：3
解释：因为第四行不完整，所以返回 3 。

链接：https://leetcode.cn/problems/arranging-coins
*/
public class Lc441 {
    /**
     * 对于满的n行的数的和为 n*(n+1)/2
     * 题目相当于求一个k且满足  k*(k+1)/2 <= n < (k+1)*(k+2)/2
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt( (long) (8 * n + 1)) - 1) / 2;
    }

    /**
     * 也可以使用二分法
     * 从 1到n 分别计算
     */
    public int arrangeCoins2(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
}
