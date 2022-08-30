package com.eachenkuang.suixianglu.dp;

/**
 * @author eachenkuang
 * @date 2022/8/29 11:31 AM
 * @description:
 */
public class UniqueBinarySearchTrees {
    /**
     * 动态规划
     * 举几个例子，从 n=1 到 n=3
     * 可以发现规律，就是固定上面的根节点，左子树和右子树会变化，从左边0，右边 n-1，一直到 左边 n-1 到 0
     * @param n
     * @return
     */
    public static int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1; // 没有节点的话，算一种。
        dp[1] = 1; // 只有一个节点的话，也只有一种
//        dp[2] = 2;
//        dp[3] = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0];
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                // 需要累加
                dp[i] += dp[j] * dp[i-j-1];
            }
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(numTrees(n));
    }
}
