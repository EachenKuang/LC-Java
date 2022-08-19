package com.eachenkuang.sort;

/**
 * @author eachenkuang
 * @date 2022/8/19 7:16 PM
 * @description:
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {3,5,16,4,0};
        for (int num: selectSort(nums)) {
            System.out.println(num);
        }
    }

    private static int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Tool.swap(nums, minIndex, i);
            }
        }
        return nums;
    }
}
