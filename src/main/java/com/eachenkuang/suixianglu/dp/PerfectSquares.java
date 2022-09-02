package com.eachenkuang.suixianglu.dp;

import com.eachenkuang.arrays.Solution;

/**
 * @author eachenkuang
 * @date 2022/9/1 10:35
 * @description:
 */
public class PerfectSquares {
    /**
     * 实际上也是一个完全背包问题
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i < n+1; i++) {
            dp[i] = n+1; // 设置为比目标值大就可以
        }
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j < n + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
            }
        }
        return dp[n];
    }


    /**
     * 数学方法解决
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.print(numSquares(n));
    }
}
