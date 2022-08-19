package com.eachenkuang.sort;

/**
 * @author eachenkuang
 * @date 2022/8/19 7:02 PM
 * @description:
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {3,5,16,4,0};
        for (int num: insertionSort(nums)) {
            System.out.println(num);
        }
    }

    private static int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int preIndex = i-1;
            while (preIndex >= 0 && current < nums[preIndex]) {
                nums[preIndex+1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex+1] = current;
        }
        return nums;
    }
}
