package com.eachenkuang.sort;

/**
 * @author eachenkuang
 * @date 2022/8/19 7:00 PM
 * @description:
 */
public class Tool {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
