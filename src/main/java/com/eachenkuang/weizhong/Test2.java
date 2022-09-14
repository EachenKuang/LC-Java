package com.eachenkuang.weizhong;

/**
 * @author eachenkuang
 * @date 2022/9/6 19:48
 * @description:
 */
public class Test2 {

    /**
     * 一次买，一次卖，利润最大
     * 测试数据：{9,11,8,5,7,12,16,14}
     * @param nums
     * @return
     */

    // 暴力法 O(N^2)
    public static int stock(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                result = Math.max(nums[j] - nums[i], result);
            }
        }
        return result;
    }

    // 应该是找当前值的后续的最大值
    public static int stock2(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int result = 0;
        int curr = 0;
        int[] diff = new int[nums.length-1];
        for (int i = 0; i < nums.length-1; i++) {
            diff[i] = nums[i+1] - nums[i];
        }
        for (int i = 0; i < diff.length; i++) {
            curr += diff[i];
            if (curr > 0) {
                result = Math.max(result, curr);
            } else {
                curr = 0;
            }
        }
        return result;
    }

    public static int stock3(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int result = 0;
        int curr = 0;
        for (int i = 0; i < nums.length-1; i++) {
            curr += nums[i+1] - nums[i];;
            if (curr > 0) {
                result = Math.max(result, curr);
            } else {
                curr = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9,11,8,5,7,12,16,14};
        int[] nums2 = {4,11,8,5,7,12,16,14};
        int[] nums3 = {9,11,2,8,5,7,12,16,14};
        System.out.print(stock(nums));
        System.out.print(stock2(nums));
        System.out.print(stock(nums2));
        System.out.print(stock2(nums2));
        System.out.print(stock(nums3));
        System.out.print(stock2(nums3));
        System.out.print(stock3(nums3));
    }
}
