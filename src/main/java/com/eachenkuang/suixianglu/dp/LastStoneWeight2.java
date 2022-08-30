package com.eachenkuang.suixianglu.dp;

/**
 * @author eachenkuang
 * @date 2022/8/29 4:58 PM
 * @description:
 */
public class LastStoneWeight2 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = sum >> 1;
        //初始化dp数组
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            //采用倒序
            for (int j = target; j >= stones[i]; j--) {
                //两种情况，要么放，要么不放
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        int[] nums2 = {1,2,3,5};
        LastStoneWeight2 solution = new LastStoneWeight2();
        int result = solution.lastStoneWeightII(nums);
        System.out.print(result);
        result = solution.lastStoneWeightII(nums2);
        System.out.print(result);
    }
}
