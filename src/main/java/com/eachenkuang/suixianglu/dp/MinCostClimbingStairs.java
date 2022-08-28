package com.eachenkuang.suixianglu.dp;

public class MinCostClimbingStairs {
    /**
     * 这题需要到达顶部，也就是要越过最后一个值
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1]; // 到达i需要的最小费用
        for (int i = 2; i < cost.length+1; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
            System.out.print(dp[i]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs solution = new MinCostClimbingStairs();
        int[] cost = {10,15,20};
        int result = solution.minCostClimbingStairs(cost);
        System.out.print(result);
    }
}
