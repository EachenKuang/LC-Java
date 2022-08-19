package com.eachenkuang.sort;

/**
 * @author eachenkuang
 * @date 2022/8/19 5:17 PM
 * @description:
 */
public class QuickSort {

    public static int[] quickSort(int[] nums) {
        return quickSort(nums, 0, nums.length-1);
    }

    public static int[] quickSort(int[] nums, int i, int j) {
        if (i > j) {
            return nums;
        }
        int pivot = partition(nums, i, j);
        quickSort(nums, i, pivot-1);
        quickSort(nums, pivot+1, j);
        return nums;
    }

    public static int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        if (i > j) {
            return i;
        }
        int pivotValue = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= pivotValue) {
                j--;
            }
            while (i < j && nums[i] <= pivotValue) {
                i++;
            }
            Tool.swap(nums, i, j);
        }
        Tool.swap(nums, left, i);
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,16,4,0};
        for (int num: quickSort(nums)) {
            System.out.println(num);
        }
    }
}
