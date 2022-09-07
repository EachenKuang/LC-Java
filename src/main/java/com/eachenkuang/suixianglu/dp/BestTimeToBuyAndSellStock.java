package com.eachenkuang.suixianglu.dp;

import com.eachenkuang.arrays.Solution;

/**
 * @author eachenkuang
 * @date 2022/9/7 09:48
 * @description:
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 */
public class BestTimeToBuyAndSellStock {

    /**
     * 暴力法
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

    /**
     * 贪心，左边取历史最小值，右边取最大值
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * dp
     * 第i天持有：dp[i][0] = max(dp[i - 1][0], -prices[i]);
     * 第i天不持有：dp[i][1] = max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int length = prices.length;

        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[length - 1][1];
    }

    /**
     * 优化
     * @param prices
     * @return
     */
    public static int maxProfit4(int[] prices) {
        int[] dp = new int[2];
        // 记录一次交易，一次交易有买入卖出两种状态
        // 0代表持有，1代表卖出
        dp[0] = -prices[0];
        dp[1] = 0;
        // 可以参考斐波那契问题的优化方式
        // 我们从 i=1 开始遍历数组，一共有 prices.length 天，
        // 所以是 i<=prices.length
        for (int i = 1; i <= prices.length; i++) {
            // 前一天持有；或当天买入
            dp[0] = Math.max(dp[0], -prices[i - 1]);
            // 如果 dp[0] 被更新，那么 dp[1] 肯定会被更新为正数的 dp[1]
            // 而不是 dp[0]+prices[i-1]==0 的0，
            // 所以这里使用会改变的dp[0]也是可以的
            // 当然 dp[1] 初始值为 0 ，被更新成 0 也没影响
            // 前一天卖出；或当天卖出, 当天要卖出，得前一天持有才行
            dp[1] = Math.max(dp[1], dp[0] + prices[i - 1]);
        }
        return dp[1];
    }



    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.print(maxProfit3(prices));
    }
}
