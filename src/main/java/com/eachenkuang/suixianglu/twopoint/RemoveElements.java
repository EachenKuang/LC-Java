package com.eachenkuang.suixianglu.twopoint;

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
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            while (nums[fast] == val) {
                // 找到第一个不为val值
                fast++;
            }
            // 赋值
            nums[slow++] = nums[fast++];

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
        int val2 = 2;
        removeElements2(nums2, val2);
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i]);
            System.out.print(" ");
        }
        
    }
    
}
