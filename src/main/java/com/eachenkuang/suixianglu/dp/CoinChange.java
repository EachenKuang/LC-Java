package com.eachenkuang.suixianglu.dp;

/**
 * @author eachenkuang
 * @date 2022/8/30 2:31 PM
 * @description:
 */
public class CoinChange {
    /**
     * 这也是一个完全背包的问题，只不过 dp 中的是方案数
     * 递推公式
     * dp[j] += dp[j-coins[i]
     * @param amount
     * @param coins
     * @return
     */
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1; // 组成0的方案只有一种，就是啥都没有
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount+1; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.printf("%d:%d, ", i, dp[i]);
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.print(change(amount, coins));
    }
}
