package com.eachenkuang.leetcode;

import com.eachenkuang.arrays.Solution;

/**
 * @author eachenkuang
 * @date 2022/10/17 09:18
 * @description:
 * 给定一个整数数组 nums，处理以下类型的多个查询:
 *
 * 计算索引left和right（包含 left 和 right）之间的 nums 元素的 和 ，其中left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums中索引left和right之间的元素的 总和 ，包含left和right两点（也就是nums[left] + nums[left + 1] + ... + nums[right])
 * 
 *
 * 示例 1：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 */
public class Lc303 {
    class NumArray {
        int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int ans = 0;
            for (int i = left; i < right+1; i++) {
                ans += nums[i];
            }
            return ans;
        }
    }

    /**
     * 前缀后算法
     */
    class NumArray2 {
        int[] sums;

        public NumArray2(int[] nums) {
            int n = nums.length;
            sums = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }

}
