package com.eachenkuang.suixianglu.dp;

/**
 * @author eachenkuang
 * @date 2022/8/30 2:16 PM
 * @description:
 * 完全背包
 */
public class CompletedBag {
    /**
     * 完全背包的动态规划
     * @return
     */
    public static int completeBag(int[] weights, int[] values, int bagSize) {
        int[] dp = new int[bagSize+1];

        for (int i = 0; i < weights.length; i++) {
            for (int j = weights[i]; j < bagSize+1; j++) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.printf("%d:%d, ", i, dp[i]);
        }
        return dp[bagSize];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4};
        int[] values = {15, 20, 30};
        int bagsize = 9;
        System.out.print(completeBag(weights, values, bagsize));
    }
}
