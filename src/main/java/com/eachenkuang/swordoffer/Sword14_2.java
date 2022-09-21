package com.eachenkuang.swordoffer;

/**
 * @author eachenkuang
 * @date 2022/9/21 15:20
 * @description:
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36
 * 2 <= n <= 1000
 */
public class Sword14_2 {
    /**
     * 数学归纳法，分解成 3，3，3，4
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        return result * n;
    }

    /**
     * 动态规划
     * dp[i] 表示将正整数 i 拆分成至少两个正整数后，最大的乘积
     * 时间复杂度 O(N^2)
     * @param n
     * @return
     */
    public static int cuttingRope2(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i < n+1; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public int cuttingRope3(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) {
                rem = (rem * x) % p;
            }
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }

    public static void main(String[] args) {
        for (int i = 2; i < 10; i++) {
            System.out.println(cuttingRope(i));
            System.out.println(cuttingRope2(i));
        }
    }
}
