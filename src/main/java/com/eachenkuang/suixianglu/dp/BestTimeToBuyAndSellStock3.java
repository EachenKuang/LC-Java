package com.eachenkuang.suixianglu.dp;

/**
 * @author eachenkuang
 * @date 2022/9/7 11:25
 * @description:
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 
 *
 * 示例1:
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2：
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3：
 *
 * 输入：prices = [7,6,4,3,1] 
 * 输出：0 
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 示例 4：
 *
 * 输入：prices = [1]
 * 输出：0
 *
 */
public class BestTimeToBuyAndSellStock3 {
    /**
     * dp法
     * 确定dp数组以及下标的含义
     * 一天一共就有五个状态，
     * 1. 没有操作
     * 2. 第一次买入
     * 3. 第一次卖出
     * 4. 第二次买入
     * 5. 第二次卖出
     * dp[i][j]中 i表示第i天，j为 [0 - 4] 五个状态，dp[i][j]表示第i天状态j所剩最大现金。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n × 5)
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        // 从前往后遍历
        for (int i = 1; i < prices.length; i++) {
            // 不操作
            dp[i][0] = dp[i-1][0];
            // 第一次买入
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            // 第一次卖出
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            // 第二次买入
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            // 第二次卖出
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }
        return dp[prices.length-1][4];
    }

    /**
     * 空间优化的版本
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int[] dp = new int[4];
        // 存储两次交易的状态就行了
        // dp[0]代表第一次交易的买入
        dp[0] = -prices[0];
        // dp[1]代表第一次交易的卖出
        dp[1] = 0;
        // dp[2]代表第二次交易的买入
        dp[2] = -prices[0];
        // dp[3]代表第二次交易的卖出
        dp[3] = 0;
        for(int i = 1; i <= prices.length; i++){
            // 要么保持不变，要么没有就买，有了就卖
            dp[0] = Math.max(dp[0], -prices[i-1]);
            dp[1] = Math.max(dp[1], dp[0]+prices[i-1]);
            // 这已经是第二次交易了，所以得加上前一次交易卖出去的收获
            dp[2] = Math.max(dp[2], dp[1]-prices[i-1]);
            dp[3] = Math.max(dp[3], dp[2]+ prices[i-1]);
        }
        return dp[3];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.print(maxProfit(prices));
    }
}
