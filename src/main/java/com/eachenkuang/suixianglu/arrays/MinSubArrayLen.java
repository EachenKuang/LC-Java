package com.eachenkuang.suixianglu.arrays;

public class MinSubArrayLen {

    public static int minSubArrayLen(int[] nums, int val) {
        int result = Integer.MAX_VALUE;
        int startIndex = 0; // 起始窗口
        int sum = 0; // 存放窗口总和
        int subLength = 0; // 滑动窗口的长度
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= val) {
                subLength = i - startIndex + 1;
                result = result > subLength ? subLength: result;
                sum -= nums[startIndex];
                startIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 6, 10};
        int target = 20;
        System.out.print(minSubArrayLen(nums, target));
    }
    
}
