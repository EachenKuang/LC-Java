package com.eachenkuang.sort;

/**
 * @author eachenkuang
 * @date 2022/8/19 6:57 PM
 * @description:
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean swapped = false; // 记录是否改变，如果为false说明已经排好序
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    Tool.swap(nums, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {3,5,16,4,0};
        bubbleSort(nums);
        for (int num: nums) {
            System.out.println(num);
        }
    }
}
