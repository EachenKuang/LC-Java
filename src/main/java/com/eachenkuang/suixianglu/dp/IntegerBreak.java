package com.eachenkuang.suixianglu.dp;

/**
 * @author eachenkuang
 * @date 2022/8/29 10:06 AM
 * @description:
 */
public class IntegerBreak {
    /**
     * 数学归纳法可以证明，分解为3是最大的，如果最后有4，则保留2*2
     * @param n
     * @return
     */
    public static int integerBreak(int n) {

        int result = 1;
        if (n == 2) {
            return result;
        }
        if (n == 3) {
            return 2;
        }
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        return result * n;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int integerBreak2(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n+1];
        // 初始化
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i < n+1; i++) {
            for (int j = 1; j < i-1; j++) {
                // j * (i - j) 是单纯的把整数拆分为两个数相乘，而j * dp[i - j]是拆分成两个以及两个以上的个数相乘
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];

    }

    /**
     * O(1) 时间复杂度
     * @param n
     * @return
     */
    public int integerBreak3(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            System.out.println(integerBreak(i));
            System.out.println(integerBreak2(i));
        }

    }
}
