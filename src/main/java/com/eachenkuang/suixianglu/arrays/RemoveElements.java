package com.eachenkuang.suixianglu.arrays;

public class RemoveElements {

    public static int[] removeElements(int[] nums, int val) {
        // 双指针
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return nums;
    }

    public static int[] removeElements2(int[] nums, int val) {
        // 这个解法是有问题的
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            // 找左边等于val的元素
            while (leftIndex <= rightIndex && nums[leftIndex] != val){
                ++leftIndex;
            }
            // 找右边不等于val的元素
            while (leftIndex <= rightIndex && nums[rightIndex] == val) {
                --rightIndex;
            }
            // 将右边不等于val的元素覆盖左边等于val的元素
            if (leftIndex < rightIndex) {
                nums[leftIndex++] = nums[rightIndex--];
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,4,5};
        int val = 2;
        removeElements(nums, val);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
        System.out.println();
        int[] nums2 = {0,1,2,2,3,4,5};
        int val2 = 0;
        removeElements2(nums2, val2);
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i]);
            System.out.print(" ");
        }
        
    }
    
}
