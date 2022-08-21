package com.eachenkuang.suixianglu.arrays;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        
        // 需要看左右区间来判断 while 中的条件情况
        // 左右闭区间，那么 left = right 这种条件下是有效的解，所以需要 <=
        // 左闭右开区间，那么 left = right 本身这种条件是无效的，所欲使用 <
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 6, 10};
        int target = 6;
        System.out.print(binarySearch(nums, target));
    }
    
}
