package com.eachenkuang.suixianglu.monotonicstack;

import com.eachenkuang.suixianglu.dp.PartitionEqualSubsetsSum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author eachenkuang
 * @date 2022/9/20 10:07
 * 
 * 给定一个循环数组nums（nums[nums.length - 1]的下一个元素是nums[0]），返回nums中每个元素的 下一个更大元素 。
 *
 * 数字 x的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * 
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数； 
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * 示例 2:
 *
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 *
 */
public class NextGreaterElement2 {
    /**
     * 此题的关键是解决循环数组的问题，可以通过走两遍循环来完成
     * 单调栈+循环数组
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        for (int i = 1; i < nums.length * 2; i++) {
            // 情况一
            if (nums[i % nums.length] <= nums[deque.peek()]) {
                deque.push(i % nums.length);
            } else {
                while (!deque.isEmpty() && nums[i % nums.length] > nums[deque.peek()]) {
                    result[deque.peek()] = nums[i % nums.length];
                    deque.pop();
                }
                deque.push(i % nums.length);
            }
        }
        return result;
    }

    /**
     * 精简
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements2(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length * 2; i++) {
            while (!deque.isEmpty() && nums[i % nums.length] > nums[deque.peek()]) {
                result[deque.peek()] = nums[i % nums.length];
                deque.pop();
            }
            deque.push(i % nums.length);

        }
        return result;
    }


        public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] result = nextGreaterElements2(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            System.out.print(" ");
        }
    }
}
