package com.eachenkuang.suixianglu.dp;

/**
 * @author eachenkuang
 * @date 2022/8/29 2:53 PM
 * @description:
 */
public class ZeroOneBag {

    /**
     * 动态规划，基本使用方式
     * @param weights
     * @param values
     * @param bagSize
     * @return
     */
    public static int bag(int[] weights, int[] values, int bagSize) {
        int length = weights.length; // 物品数量
        int[][] dp = new int[length][bagSize+1];
        // 初始化 dp[0][i]  dp[i][0]
        for (int i = weights[0]; i < bagSize+1; i++) {
            dp[0][i] = values[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < bagSize+1; j++) {
                if (j-weights[i] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weights[i]] + values[i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[length-1][bagSize];
    }

    /**
     * 使用滚动数组
     * @param weights
     * @param values
     * @param bagSize
     * @return
     */
    public static int bag2(int[] weights, int[] values, int bagSize) {
        int length = weights.length; // 物品数量
        int[] dp = new int[bagSize+1];
        // 初始化 dp 数组
        for (int i = weights[0]; i < bagSize+1; i++) {
            dp[i] = values[0];
        }
        for (int i = 1; i < length; i++) {
            // 注意这里要倒序，避免被覆盖
            for (int j = bagSize; j > 0; j--) {
                if (j >= weights[i]) {
                    // dp[j] 是上一层的数据，表示不放 i 物品
                    // dp[j-weights[i]] + values[i] 表示放 i 物品
                    dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.printf("%d:%d, ", i, dp[i]);
        }
        return dp[bagSize];
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int bagsize = 4;
        System.out.print(bag2(weights, values, bagsize));
    }
}
