package com.eachenkuang.arrays;

/**
 * @author eachenkuang
 * @date 2022/1/22 6:40 下午
 * @description:
 */
public class Solution {
    /**
     * Given a binary array nums, return the maximum number of consecutive 1's in the array.
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 0;
            } else {
                count ++;
                maxCount = Math.max(maxCount, count);
            }

        }
        return maxCount;
    }

    /**
     * Given an array nums of integers, return how many of them contain an even number of digits.
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num: nums
             ) {
            if (isBitCountEven(num)) {
                count++;
            }
        }
        return count;
    }

    private boolean isBitCountEven(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count%2 == 0;
    }

    /**
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted
     * in non-decreasing order.
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int former = 0;
        int latter = nums.length - 1;
        int[] result = new int[nums.length];
        int pos = nums.length - 1;
        while (former <= latter) {
            // 判断条件可以优化，
            // Math.abs(nums[former]) >= Math.abs(nums[latter]) 使用了 Math.abs
            // 可以改成 (nums[former] + nums[latter] <= 0)
            // 左边一定是小于右边，如果左边绝对值大于右边，则两者的和一定小于0
            if (Math.abs(nums[former]) >= Math.abs(nums[latter])) {
                result[pos] = nums[former] * nums[former];
                former++;
            } else {
                result[pos] = nums[latter] * nums[latter];
                latter--;
            }
            pos--;
        }
        return result;
    }

    /**
     * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to
     * the right.
     *
     * Note that elements beyond the length of the original array are not written. Do the above modifications to the
     * input array in place and do not return anything.
     *
     * 方法一：
     * 遍历过程中，移动后面的位置
     *
     * 方法二：
     * 先计算出0的
     *
     * @param arr
     * @return
     */
    public void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }

    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
     * representing the number of elements in nums1 and nums2 respectively.
     *
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     *
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
     * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should
     * be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length_ = nums1.length;

    }

}
