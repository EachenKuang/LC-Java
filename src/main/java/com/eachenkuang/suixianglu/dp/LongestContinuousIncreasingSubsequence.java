package com.eachenkuang.suixianglu.dp;

import java.util.Arrays;

/**
 * @author eachenkuang
 * @date 2022/9/14 16:29
 * @description:
 */
public class LongestContinuousIncreasingSubsequence {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS(int[] nums) {
        int result = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                temp++;
            } else {
                temp = 1;
            }
            result = Math.max(result, temp);
        }
        return result;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,4,5};
        System.out.print(findLengthOfLCIS(nums));
        System.out.print(findLengthOfLCIS2(nums));
    }
}
