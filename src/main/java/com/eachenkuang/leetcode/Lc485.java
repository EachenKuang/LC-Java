package com.eachenkuang.leetcode;

/**
 * @author eachenkuang
 * @date 2022/10/26 09:34
 * @description:
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
示例 1：

输入：nums = [1,1,0,1,1,1]
输出：3
解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
示例 2:

输入：nums = [1,0,1,1,0,1]
输出：2

链接：https://leetcode.cn/problems/max-consecutive-ones
 */
public class Lc485 {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int curCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curCount++;
                maxCount = Math.max(curCount, maxCount);
            } else {
                curCount = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1,0,1};
        System.out.print(findMaxConsecutiveOnes(nums));
    }
}
