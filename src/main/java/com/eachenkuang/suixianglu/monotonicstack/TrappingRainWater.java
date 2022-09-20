package com.eachenkuang.suixianglu.monotonicstack;

import java.util.Stack;

/**
 * @author eachenkuang
 * @date 2022/9/20 10:23
 * @description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 */
public class TrappingRainWater {
    /**
     * 计算每列的高度
     * 第一列和最后一列不接雨水
     * 每一列雨水的高度，取决于，该列左侧最高的柱子和右侧最高的柱子的这两者中，较矮的那个柱子的高度。
     * 时间复杂度 O(n^2)
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int rHeight = height[i]; // 记录右边柱子的最高高度
            int lHeight = height[i]; // 记录左边柱子的最高高度
            for (int r = i + 1; r < height.length; r++) {
                if (height[r] > rHeight) rHeight = height[r];
            }
            for (int l = i - 1; l >= 0; l--) {
                if (height[l] > lHeight) lHeight = height[l];
            }
            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0) sum += h;
        }
        return sum;
    }

    /**
     * 使用动态规划来避免左右最大值的重复计算，种类使用两个数组来存储
     * O(n)
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int length = height.length;
        if (length <= 2) {
            return 0;
        }
        int[] maxLeftHeight = new int[length];
        int[] maxRightHeight = new int[length];
        // 记录每个柱子左边柱子最大高度
        maxLeftHeight[0] = height[0];
        for (int i = 1; i < length; i++) {
            maxLeftHeight[i] = Math.max(height[i], maxLeftHeight[i - 1]);
        }
        // 记录每个柱子右边柱子最大高度
        maxRightHeight[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            maxRightHeight[i] = Math.max(height[i], maxRightHeight[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int count = Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
            if (count > 0) sum += count;
        }
        return sum;
    }

    /**
     * 双指针法
     * 时间 O(n)
     * 空间 O(1)
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    public int trap4(int[] height){
        int size = height.length;

        if (size <= 2) return 0;

        // in the stack, we push the index of array
        // using height[] to access the real height
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int sum = 0;
        for (int index = 1; index < size; index++){
            int stackTop = stack.peek();
            if (height[index] < height[stackTop]){
                stack.push(index);
            }else if (height[index] == height[stackTop]){
                // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                stack.pop();
                stack.push(index);
            }else{
                //pop up all lower value
                int heightAtIdx = height[index];
                while (!stack.isEmpty() && (heightAtIdx > height[stackTop])){
                    int mid = stack.pop();

                    if (!stack.isEmpty()){
                        int left = stack.peek();

                        int h = Math.min(height[left], height[index]) - height[mid];
                        int w = index - left - 1;
                        int hold = h * w;
                        if (hold > 0) sum += hold;
                        stackTop = stack.peek();
                    }
                }
                stack.push(index);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trap2(height));

    }
}
