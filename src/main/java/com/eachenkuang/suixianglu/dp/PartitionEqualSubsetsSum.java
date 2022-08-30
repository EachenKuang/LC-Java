package com.eachenkuang.suixianglu.dp;

/**
 * @author eachenkuang
 * @date 2022/8/29 4:32 PM
 * @description:
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 其实就是看，能不能满足选取其中的数的结果为 sum/2
 */
public class PartitionEqualSubsetsSum {
    /**
     * 使用 0，1背包来实现
     * 可以再增加一些剪枝操作，例如，找到最大的数，如果最大的数大于 sum/2 ,则直接返回 false
     * 如果数量小于2，则不可能被分割
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 == 1) {
            // 如果为奇数，则不用计算了
            return false;
        }
        int bagSize = sum / 2;
        int length = nums.length;
        int[] dp = new int[bagSize+1];
        // 初始化 dp
        for (int i = nums[0]; i < bagSize+1; i++) {
            dp[i] = nums[0];
        }

        for (int i = 1; i < length; i++) {
            for (int j = bagSize; j > 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
                }
            }
        }
        return dp[bagSize] == bagSize;
    }

    public int getSum(int[] nums) {
        int count = 0;
        for (int num: nums
             ) {
            count += num;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        int[] nums2 = {1,2,3,5};
        PartitionEqualSubsetsSum solution = new PartitionEqualSubsetsSum();
        boolean result = solution.canPartition(nums);
        System.out.print(result);
        result = solution.canPartition(nums2);
        System.out.print(result);
    }
}
