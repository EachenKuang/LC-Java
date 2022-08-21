package com.eachenkuang.suixianglu.arrays;

public class SquareOfSortedArray {

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int k = nums.length - 1;
        int[] ans = new int[nums.length];
        while (left <= right) {
            int squareA = nums[left] * nums[left];
            int squareB = nums[right] * nums[right];
            if (squareA >= squareB) {
                ans[k] = squareA;
                left++;
            } else {
                ans[k] = squareB;
                right--;
            }
            k--;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {-6, -3, -1, 0, 1, 2, 2, 3, 4, 5};
        int[] ans = sortedSquares(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
            System.out.print(" ");
        }
    }
}
