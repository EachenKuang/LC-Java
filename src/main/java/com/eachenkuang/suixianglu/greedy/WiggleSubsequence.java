package com.eachenkuang.suixianglu.greedy;

/**
 * @author eachenkuang
 * @date 2022/8/26 11:19 AM
 * @description:
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 *
 * 例如，[1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3)是正负交替出现的。
 *
 * 相反，[1, 4, 7, 2, 5]和[1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 *
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 * 示例 1：
 *
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 * 示例 2：
 *
 * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。
 * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,5,6,7,8,9]
 * 输出：2
 *
 */

public class WiggleSubsequence {
    /**
     * 贪心算法
     * 实际上找到谷峰+1
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int currentDiff = 0;
        int preferDiff = 0;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            currentDiff = nums[i] - nums[i-1];
            if ((currentDiff > 0 && preferDiff <= 0) || (currentDiff < 0 && preferDiff >= 0)) {
                result++;
                preferDiff = currentDiff;
            }

        }
        return result;
    }

    /**
     * 动态规划
     * up[i] 表示以前 i 个元素中的某一个为结尾的最长的「上升摆动序列」的长度。
     *
     * down[i] 表示以前 i 个元素中的某一个为结尾的最长的「下降摆动序列」的长度。
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }

    public static void main(String[] args) {

        WiggleSubsequence solution = new WiggleSubsequence();

        int[] input1 = {1, 7, 4, 9, 2, 5};
        int result1 = solution.wiggleMaxLength(input1);
        System.out.print(result1);

        int[] input2 = {1, 4, 7, 2, 5};
        int result2 = solution.wiggleMaxLength(input2);
        System.out.print(result2);

        int[] input3 = {1,2,3,4,5,6,7,8,9};
        int result3 = solution.wiggleMaxLength(input3);
        System.out.print(result3);

    }
}
