package com.eachenkuang.suixianglu.dp;

/**
 * @author eachenkuang
 * @date 2022/9/7 10:06
 * @description:
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *     总利润为 4 。
 * 示例3：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 *
 */
public class BestTimeToBuyAndSellStock2 {

    /**
     * dp[i][0] 表示第i天持有股票所得现金。
     * dp[i][1] 表示第i天不持有股票所得最多现金
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int length = prices.length;
        int[][] dp = new int[length][2];     // 创建二维数组存储状态
        dp[0][1] = 0;                   // 初始状态
        dp[0][0] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);    // 第 i 天，没有股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);    // 第 i 天，持有股票
        }
        return dp[length - 1][1];    // 卖出股票收益高于持有股票收益，因此取[0]
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.print(maxProfit(prices));
    }
}
