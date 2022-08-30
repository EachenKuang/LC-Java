package com.eachenkuang.suixianglu.dp;

import com.eachenkuang.arrays.Solution;

/**
 * @author eachenkuang
 * @date 2022/8/29 7:45 PM
 * @description:
 */
public class FindTargetSumWays {
    /**
     * 可以把 + - 想象成两个集合，nums 中的一些数放在 + 集合中 add，另一些数放在 - 集合中 minus
     * 那
     * Sum(all) = Sum(add) + Sum(minus)
     * target = Sum(add) - Sum(minus)
     * 从而求出两个集合的各自的和出来。
     * 然后通过 0 - 1背包问题，解决
     */
    public int findTargetSumWays(int[] nums, int target) {

        int sum = getSum(nums);
        return 0;
    }

    public static int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    public int getSum(int[] nums) {
        int count = 0;
        for (int num: nums
             ) {
            count += num;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 1;
        System.out.print(findTargetSumWays2(nums, target));
    }
}
