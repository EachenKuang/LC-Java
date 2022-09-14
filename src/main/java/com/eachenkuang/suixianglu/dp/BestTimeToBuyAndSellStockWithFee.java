package com.eachenkuang.suixianglu.dp;

import com.eachenkuang.arrays.Solution;

/**
 * @author eachenkuang
 * @date 2022/9/14 11:00
 * @description:
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * 示例 2：
 *
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 */
public class BestTimeToBuyAndSellStockWithFee {
    /**
     *  dp[i][0] 表示第i天持有股票所得现金。
     *  dp[i][1] 表示第i天不持有股票所得最多现金
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = - fee - prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length-1][1];
    }

    /**
     * 滚动数组优化，只需要两个变量，买入时缴费
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit2(int[] prices, int fee) {
        int dp0 = - prices[0];
        int dp1 = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = Math.max(dp0, dp1 - prices[i]);
            dp1 = Math.max(dp1, dp0 + prices[i] - fee);
            dp0 = temp;
        }
        return dp1;
    }

    /**
     * 卖出时缴费
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit3(int[] prices, int fee) {
        int dp0 = - prices[0] - fee;
        int dp1 = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = Math.max(dp0, dp1 - prices[i] - fee);
            dp1 = Math.max(dp1, dp0 + prices[i]);
            dp0 = temp;
        }
        return dp1;
    }

    /**
     * 贪心
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit4(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.print(maxProfit(prices, fee));
        System.out.print(maxProfit2(prices, fee));
    }
}
