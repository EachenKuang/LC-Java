package com.eachenkuang.suixianglu.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/8/22 11:14 AM
 * @description:
 * 题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。 满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 */
public class FourSum {
    /**
     * 注意这道题和三数之和的相似之处，另外注意剪枝的操作的可行性
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if (nums[i] > 0 && nums[i] > target) {
                break;
            }
            // 对于a的去重逻辑
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // 这里实际上逻辑回到三数之和的情况，不过注意判断条件是变成四数之和与Target的比较
            for (int j = i+1; j < nums.length; j++) {
                // 二层剪枝
                if (nums[i] + nums[j]> 0 && nums[i] + nums[j] > target && target > 0) {
                    break;
                }
                // 对于 b 的去重，这里需要特别注意，需要从 i+1 的下个位置开始准备去重
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        // 获得值
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对于 left与right进行去重
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
