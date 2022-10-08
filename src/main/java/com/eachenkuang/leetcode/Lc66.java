package com.eachenkuang.leetcode;

/**
 * @author eachenkuang
 * @date 2022/10/8 15:26
 * @description:
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 
 *
 * 示例1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 */
public class Lc66 {
    /**
     * 找到最后有多少个连续的9，直到不为9的那位，9的位都置位0，不为9的加1
     * 如果是全部为9，那么需要新建一个新的数组
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
